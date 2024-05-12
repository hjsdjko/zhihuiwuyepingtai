
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
 * 车位订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheweiOrder")
public class CheweiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(CheweiOrderController.class);

    private static final String TABLE_NAME = "cheweiOrder";

    @Autowired
    private CheweiOrderService cheweiOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private ChatService chatService;//投诉管理
    @Autowired
    private CheweiService cheweiService;//车位
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
        CommonUtil.checkMap(params);
        PageUtils page = cheweiOrderService.queryPage(params);

        //字典表数据转换
        List<CheweiOrderView> list =(List<CheweiOrderView>)page.getList();
        for(CheweiOrderView c:list){
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
        CheweiOrderEntity cheweiOrder = cheweiOrderService.selectById(id);
        if(cheweiOrder !=null){
            //entity转view
            CheweiOrderView view = new CheweiOrderView();
            BeanUtils.copyProperties( cheweiOrder , view );//把实体数据重构到view中
            //级联表 车位
            //级联表
            CheweiEntity chewei = cheweiService.selectById(cheweiOrder.getCheweiId());
            if(chewei != null){
            BeanUtils.copyProperties( chewei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setCheweiId(chewei.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(cheweiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody CheweiOrderEntity cheweiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheweiOrder:{}",this.getClass().getName(),cheweiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            cheweiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        cheweiOrder.setCreateTime(new Date());
        cheweiOrder.setInsertTime(new Date());
        cheweiOrderService.insert(cheweiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheweiOrderEntity cheweiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,cheweiOrder:{}",this.getClass().getName(),cheweiOrder.toString());
        CheweiOrderEntity oldCheweiOrderEntity = cheweiOrderService.selectById(cheweiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            cheweiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            cheweiOrderService.updateById(cheweiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CheweiOrderEntity> oldCheweiOrderList =cheweiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        cheweiOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<CheweiOrderEntity> cheweiOrderList = new ArrayList<>();//上传的东西
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
                            CheweiOrderEntity cheweiOrderEntity = new CheweiOrderEntity();
//                            cheweiOrderEntity.setCheweiOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            cheweiOrderEntity.setCheweiId(Integer.valueOf(data.get(0)));   //车位 要改的
//                            cheweiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            cheweiOrderEntity.setCheweiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            cheweiOrderEntity.setCheweiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            cheweiOrderEntity.setInsertTime(date);//时间
//                            cheweiOrderEntity.setCreateTime(date);//时间
                            cheweiOrderList.add(cheweiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("cheweiOrderUuidNumber")){
                                    List<String> cheweiOrderUuidNumber = seachFields.get("cheweiOrderUuidNumber");
                                    cheweiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cheweiOrderUuidNumber = new ArrayList<>();
                                    cheweiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cheweiOrderUuidNumber",cheweiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<CheweiOrderEntity> cheweiOrderEntities_cheweiOrderUuidNumber = cheweiOrderService.selectList(new EntityWrapper<CheweiOrderEntity>().in("chewei_order_uuid_number", seachFields.get("cheweiOrderUuidNumber")));
                        if(cheweiOrderEntities_cheweiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CheweiOrderEntity s:cheweiOrderEntities_cheweiOrderUuidNumber){
                                repeatFields.add(s.getCheweiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cheweiOrderService.insertBatch(cheweiOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = cheweiOrderService.queryPage(params);

        //字典表数据转换
        List<CheweiOrderView> list =(List<CheweiOrderView>)page.getList();
        for(CheweiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CheweiOrderEntity cheweiOrder = cheweiOrderService.selectById(id);
            if(cheweiOrder !=null){


                //entity转view
                CheweiOrderView view = new CheweiOrderView();
                BeanUtils.copyProperties( cheweiOrder , view );//把实体数据重构到view中

                //级联表
                    CheweiEntity chewei = cheweiService.selectById(cheweiOrder.getCheweiId());
                if(chewei != null){
                    BeanUtils.copyProperties( chewei , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheweiId(chewei.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(cheweiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody CheweiOrderEntity cheweiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,cheweiOrder:{}",this.getClass().getName(),cheweiOrder.toString());
            CheweiEntity cheweiEntity = cheweiService.selectById(cheweiOrder.getCheweiId());
            if(cheweiEntity == null){
                return R.error(511,"查不到该车位");
            }
            // Double cheweiNewMoney = cheweiEntity.getCheweiNewMoney();

            if(false){
            }
            else if(cheweiEntity.getCheweiNewMoney() == null){
                return R.error(511,"金额/小时不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - cheweiEntity.getCheweiNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            cheweiOrder.setCheweiOrderTypes(101); //设置订单状态为已支付停车费
            cheweiOrder.setCheweiOrderTruePrice(cheweiEntity.getCheweiNewMoney()*1); //设置实付价格
            cheweiOrder.setYonghuId(userId); //设置订单支付人id
            cheweiOrder.setCheweiOrderUuidNumber(String.valueOf(new Date().getTime()));
            cheweiOrder.setInsertTime(new Date());
            cheweiOrder.setCreateTime(new Date());
                cheweiOrderService.insert(cheweiOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String cheweiOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");


        String data = String.valueOf(params.get("cheweis"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> cheweis = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<CheweiOrderEntity> cheweiOrderList = new ArrayList<>();
        //商品表
        List<CheweiEntity> cheweiList = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : cheweis) {
           //取值
            Integer cheweiId = Integer.valueOf(String.valueOf(map.get("cheweiId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            CheweiEntity cheweiEntity = cheweiService.selectById(cheweiId);//购买的商品
            String id = String.valueOf(map.get("id"));

            //判断商品的库存是否足够
//            if(cheweiEntity.getCheweiKucunNumber() < buyNumber){
//                //商品库存不足直接返回
//                return R.error(cheweiEntity.getCheweiName()+"的库存不足");
//            }else{
//                //商品库存充足就减库存
//                cheweiEntity.setCheweiKucunNumber(cheweiEntity.getCheweiKucunNumber() - buyNumber);
//            }

            //订单信息表增加数据
            CheweiOrderEntity cheweiOrderEntity = new CheweiOrderEntity<>();
            cheweiEntity.setCheweiZhuangtaiTypes(1);

            //赋值订单信息
            cheweiOrderEntity.setCheweiOrderUuidNumber(cheweiOrderUuidNumber);//订单编号
            cheweiOrderEntity.setCheweiId(cheweiId);//车位
                        cheweiOrderEntity.setYonghuId(userId);//用户
            cheweiOrderEntity.setCheweiOrderTypes(101);//订单类型
            cheweiOrderEntity.setInsertTime(new Date());//订单创建时间
            cheweiOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
//            if(cheweiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(cheweiEntity.getCheweiNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    cheweiOrderEntity.setCheweiOrderTruePrice(money);

                }
//            }
            cheweiOrderList.add(cheweiOrderEntity);
            cheweiList.add(cheweiEntity);

        }
        cheweiOrderService.insertBatch(cheweiOrderList);
        cheweiService.updateBatchById(cheweiList);
        yonghuService.updateById(yonghuEntity);

        return R.ok();
    }


    /**
     * 取车
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        CheweiOrderEntity  cheweiOrderEntity = cheweiOrderService.selectById(id);
        CheweiEntity cheweiEntity = cheweiService.selectById(cheweiOrderEntity.getCheweiId());//购买的商品
        cheweiEntity.setCheweiZhuangtaiTypes(2);
        cheweiOrderEntity.setCheweiOrderTypes(104);//设置订单状态为取车
        cheweiOrderService.updateById( cheweiOrderEntity);
        cheweiService.updateById(cheweiEntity);
        return R.ok();
    }

}

