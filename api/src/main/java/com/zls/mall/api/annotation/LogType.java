package com.zls.mall.api.annotation;


public enum LogType {
//    //默认类型
//    USER_OPERATION,
    /**
     * 用户注册
     */
    USER_REG,
    /**
     * 用户删除
     */
    USER_DELETE,
    //获取用户信息
    USER_INFO,
    /**
     * 1登录
     */
    USER_LOGIN,
    //登出
    USER_LOGIN_OUT,
    /**
     * 品牌列表
     */
    BRAND_LIST,
    //修改品牌
    BRAND_UPDATE,
    //删除品牌
    BRAND_DELETE,
    //增加品牌
    BRAND_ADD,
    //优选专区列表
    AREA_LIST,
    //获取商品专题
    SUBJECT_LIST,
    //货物公司地址
    COMPANY_ADDRESS,
    //订单明细
    ORDER_DETAIL,
    //修改订单备注
    ORDER_NOTE_UPDATE,
    //删除订单
    ORDER_DELETE,
    //修改订单收货人
    ORDER_RECEIVER_UPDATE,
    //修改订单费用信息
    ORDER_MONEY_UPDATE,
    //关闭订单
    ORDER_CLOE_UPDATE,
    //查询订单
    ORDER_LIST,
    //订单发货
    ORDER_DELIVERY,
    //取消超时订单
    ORDER_CANCEL,
    //分页查询退货申请
    ORDER_RETURN_APPLY,
    //删除退货申请
    ORDER_DELETE_RETURN,
    //获取退货详情
    ORDER_RETURN_DETAIL,
    //修改申请状态
    ORDER_UPDATE_RETURN_STATUS,
    //添加退货原因
    ORDER_ADD_RETURN_REASON,
    //查询退货原因
    ORDER_RETURN_REASON_LIST,
    //删除退货原因
    ORDER_DELETE_RETURN_REASON,
    //修改退货原因
    ORDER_UPDATE_RETURN_REASON,
    //获取退货原因
    ORDER_RETURN_REASON,
    //修改退货原因启用状态
    ORDER_UPDATE_RETURN_REASON_STATUS,
    //获取指定订单设置
    ORDER_DETAIL_SETTING,
    //修改指定订单设置
    ORDER_UPDATE_DETAIL_SETTING,

    //获取商品属性
    PRODUCT_ATTRIBUTE,
    //添加商品属性
    PRODUCT_ADD_ATTRIBUTE,
    //删除商品属性
    PRODUCT_DELETE_ATTRIBUTE,
    //修改商品属性
    PRODUCT_UPDATE_ATTRIBUTE,
    //获取单个商品属性分类信息
    PRODUCT_GET_ATTRIBUTE_CATEGORY,
    //获取所有商品属性分类及其下属性
    PRODUCT_ATTRIBUTE_CATEGORY,
    //根据分类查询属性列表或参数列表
    PRODUCT_ATTRIBUTE_LIST,
    //添加商品属性信息
    PRODUCT_ATTRIBUTE_ADD,
    //单个属性信息
    PRODUCT_ATTRIBUTE_DETAILS,
//根据商品分类的id获取商品属性及属性分类
    PRODUCT_CATEGORY_ID,
    //分页查询商品分类

    PRODUCT_CATEGORY_LIST,
    //添加产品分类
    PRODUCT_CATEGORY_ADD,
    //删除产品分类
    PRODUCT_CATEGORY_DELETE,

    //修改产品分类
    PRODUCT_CATEGORY_UPDATE,

    //修改导航栏显示状态

    PRODUCT_NAV_STATUS,
    //修改显示状态

    PRODUCT_SHOW_STATUS,
//查询所有一级分类及子分类
    PRODUCT_WITH_CHILDREN,
    //创建商品
    PRODUCT_ADD,
    //商品列表
    PRODUCT_LIST,
    //批量修改删除状态

    PRODUCT_DELETE_STATUS,
    //批量上下架
    PRODUCT_PUBLISH_STATUS,
    //批量推荐商品
    PRODUCT_RECOMMEND_STATUS,
    //批量设为新品
    PRODUCT_NEW_STATUS,
    //根据商品id获取商品编辑信息
    PRODUCT_ID,
    //更新商品
    PRODUCT_UPDATE,
    //根据商品编号及编号模糊搜索sku库存
    PRODUCT_GET_SKU_STOCK,
    //批量更新库存信息
    PRODUCT_UPDATE_SKU_STOCK,
    //查询所有会员等级
    UMS_MEMBER_LEVEL_LIST,

    //UserView数据统计管理
    UMS_USER_VIEW_LIST,

    //UserView统计类型管理
    UMS_USER_VIEW_TYPE_LIST,
    //修改品牌制造商状态
    BRAND_UPDATE_FACTORY_STATUS
}
