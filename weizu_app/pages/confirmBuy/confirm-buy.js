// pages/confirmBuy/confirm-buy.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pgId:'',
    rateId:'',
    chargeTel:'',
    pgPrice:'',
    pgSize:'',
    pgDiscountPrice:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // console.log(options.chargeTel);
    this.setData({
      pgId: options.pgId,
      rateId: options.rateId,
      chargeTel: options.chargeTel,
      pgPrice: options.pgPrice,
      pgSize: options.pgSize,
      pgDiscountPrice: options.pgDiscountPrice
    })
  },
  formSubmit:function(event){
    var that = this;
    var form_data = event.detail.value
    wx.login({
      success: function (res) {
        if (res.code) {
          wx.showToast({
            title: res.code,
          });
          console.info(res.code);
          wx.request({
            url: 'https://api.weixin.qq.com/sns/jscode2session',
            data: {
              js_code: res.code,
              appid: 'wxcf0590c3295581d8',
              grant_type: 'authorization_code',
              secret: '9cb60b1746e195f0e0f6f39e82257dbc'
            },
            success: function(res){
              var openid= res.data.openid;
              console.info("openid:"+openid);
              wx.setStorageSync("openid", openid);
              var pgDiscountPrice = that.data.pgDiscountPrice;
              getPrepay(openid, pgDiscountPrice, form_data);
            }

          })
        }
      }
    })  
  },
  //调用统一下单接口，生成自己的订单号，同时
  getPrepay: function (openid, money, form_data){
    var mch_id = '1401974602';
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})