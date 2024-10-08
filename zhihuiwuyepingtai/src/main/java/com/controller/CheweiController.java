
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 车位
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chewei")
public class CheweiController {
    private static final Logger logger = LoggerFactory.getLogger(CheweiController.class);

    private static final String TABLE_NAME = "chewei";

    @Autowired
    private CheweiService cheweiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private ChatService chatService;//投诉管理
    @Autowired
    private CheweiOrderService cheweiOrderService;//车位订单
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FangwuService fangwuService;//房屋
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JiaofeiService jiaofeiService;//缴费
    @Autowired
    private WeixuiService weixuiService;//维修指派
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("cheweiDeleteStart",1);params.put("cheweiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = cheweiService.queryPage(params);

        //字典表数据转换
        List<CheweiView> list =(List<CheweiView>)page.getList();
        for(CheweiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheweiEntity chewei = cheweiService.selectById(id);
        if(chewei !=null){
            //entity转view
            CheweiView view = new CheweiView();
            BeanUtils.copyProperties( chewei , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CheweiEntity chewei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chewei:{}",this.getClass().getName(),chewei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CheweiEntity> queryWrapper = new EntityWrapper<CheweiEntity>()
            .eq("chewei_name", chewei.getCheweiName())
            .eq("chewei_address", chewei.getCheweiAddress())
            .eq("chewei_types", chewei.getCheweiTypes())
            .eq("chewei_zhuangtai_types", chewei.getCheweiZhuangtaiTypes())
            .eq("chewei_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheweiEntity cheweiEntity = cheweiService.selectOne(queryWrapper);
        if(cheweiEntity==null){
            chewei.setCheweiDelete(1);
            chewei.setInsertTime(new Date());
            chewei.setCreateTime(new Date());
            cheweiService.insert(chewei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheweiEntity chewei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chewei:{}",this.getClass().getName(),chewei.toString());
        CheweiEntity oldCheweiEntity = cheweiService.selectById(chewei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chewei.getCheweiPhoto()) || "null".equals(chewei.getCheweiPhoto())){
                chewei.setCheweiPhoto(null);
        }
        if("".equals(chewei.getCheweiContent()) || "null".equals(chewei.getCheweiContent())){
                chewei.setCheweiContent(null);
        }

            cheweiService.updateById(chewei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CheweiEntity> oldCheweiList =cheweiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<CheweiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            CheweiEntity cheweiEntity = new CheweiEntity();
            cheweiEntity.setId(id);
            cheweiEntity.setCheweiDelete(2);
            list.add(cheweiEntity);
        }
        if(list != null && list.size() >0){
            cheweiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<CheweiEntity> cheweiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            CheweiEntity cheweiEntity = new CheweiEntity();
//                            cheweiEntity.setCheweiName(data.get(0));                    //车位名称 要改的
//                            cheweiEntity.setCheweiUuidNumber(data.get(0));                    //车位编号 要改的
//                            cheweiEntity.setCheweiPhoto("");//详情和图片
//                            cheweiEntity.setCheweiAddress(data.get(0));                    //车位地点 要改的
//                            cheweiEntity.setCheweiTypes(Integer.valueOf(data.get(0)));   //车位类型 要改的
//                            cheweiEntity.setCheweiZhuangtaiTypes(Integer.valueOf(data.get(0)));   //车位状态 要改的
//                            cheweiEntity.setCheweiNewMoney(data.get(0));                    //金额/小时 要改的
//                            cheweiEntity.setCheweiContent("");//详情和图片
//                            cheweiEntity.setCheweiDelete(1);//逻辑删除字段
//                            cheweiEntity.setInsertTime(date);//时间
//                            cheweiEntity.setCreateTime(date);//时间
                            cheweiList.add(cheweiEntity);


                            //把要查询是否重复的字段放入map中
                                //车位编号
                                if(seachFields.containsKey("cheweiUuidNumber")){
                                    List<String> cheweiUuidNumber = seachFields.get("cheweiUuidNumber");
                                    cheweiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheweiUuidNumber = new ArrayList<>();
                                    cheweiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheweiUuidNumber",cheweiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //车位编号
                        List<CheweiEntity> cheweiEntities_cheweiUuidNumber = cheweiService.selectList(new EntityWrapper<CheweiEntity>().in("chewei_uuid_number", seachFields.get("cheweiUuidNumber")).eq("chewei_delete", 1));
                        if(cheweiEntities_cheweiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheweiEntity s:cheweiEntities_cheweiUuidNumber){
                                repeatFields.add(s.getCheweiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [车位编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheweiService.insertBatch(cheweiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<CheweiView> returnCheweiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("cheweiYesnoTypes",2);
        PageUtils pageUtils = cheweiOrderService.queryPage(params1);
        List<CheweiOrderView> orderViewsList =(List<CheweiOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(CheweiOrderView orderView:orderViewsList){
            Integer cheweiTypes = orderView.getCheweiTypes();
            if(typeMap.containsKey(cheweiTypes)){
                typeMap.put(cheweiTypes,typeMap.get(cheweiTypes)+1);
            }else{
                typeMap.put(cheweiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("cheweiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("cheweiYesnoTypes",2);
            PageUtils pageUtils1 = cheweiService.queryPage(params2);
            List<CheweiView> cheweiViewList =(List<CheweiView>)pageUtils1.getList();
            returnCheweiViewList.addAll(cheweiViewList);
            if(returnCheweiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("cheweiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = cheweiService.queryPage(params);
        if(returnCheweiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnCheweiViewList.size();//要添加的数量
            List<CheweiView> cheweiViewList =(List<CheweiView>)page.getList();
            for(CheweiView cheweiView:cheweiViewList){
                Boolean addFlag = true;
                for(CheweiView returnCheweiView:returnCheweiViewList){
                    if(returnCheweiView.getId().intValue() ==cheweiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnCheweiViewList.add(cheweiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnCheweiViewList = returnCheweiViewList.subList(0, limit);
        }

        for(CheweiView c:returnCheweiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnCheweiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = cheweiService.queryPage(params);

        //字典表数据转换
        List<CheweiView> list =(List<CheweiView>)page.getList();
        for(CheweiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheweiEntity chewei = cheweiService.selectById(id);
            if(chewei !=null){


                //entity转view
                CheweiView view = new CheweiView();
                BeanUtils.copyProperties( chewei , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody CheweiEntity chewei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chewei:{}",this.getClass().getName(),chewei.toString());
        Wrapper<CheweiEntity> queryWrapper = new EntityWrapper<CheweiEntity>()
            .eq("chewei_name", chewei.getCheweiName())
            .eq("chewei_uuid_number", chewei.getCheweiUuidNumber())
            .eq("chewei_address", chewei.getCheweiAddress())
            .eq("chewei_types", chewei.getCheweiTypes())
            .eq("chewei_zhuangtai_types", chewei.getCheweiZhuangtaiTypes())
            .eq("chewei_delete", chewei.getCheweiDelete())
//            .notIn("chewei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheweiEntity cheweiEntity = cheweiService.selectOne(queryWrapper);
        if(cheweiEntity==null){
            chewei.setCheweiDelete(1);
            chewei.setInsertTime(new Date());
            chewei.setCreateTime(new Date());
        cheweiService.insert(chewei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

