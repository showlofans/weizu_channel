Page({
  data: {
    focus: false,
    inputValue: '',
    carrier: '',
    condition:false,
    carrierIsNull:true,
    serviceTypeEnums:[],
    ratePgList: []
  },
  radioChange: function (e) {
    // console.log('radio发生change事件，携带value值为：', e.detail.value)
    // console.log('地区：'+this.data.carrier);
    var that = this;
    wx.request({
      // url: 'http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=' + e.detail.value, //仅为示例，并非真实的接口地址
      url: 'http://www.91weizu.cn/flowsys/wechat/getpg_for_purchase.do', //仅为示例，并非真实的接口地址
      data: {
        serviceType: e.detail.value,
        carrier: that.data.carrier
      },
      header: {
        'content-type': 'application/json;charset=utf-8' // 默认值
      },
      success: function (res) {
        // console.log(res);
        // console.log(res.data);
        var condition = that.data.condition;
        that.setData({ 
          ratePgList: res.data, 
          condition: !condition 
        })
      }
    })
  },
  //跳转到购买页面
  navigateToBuy: function (e) {
    var index = parseInt(e.currentTarget.dataset.index);
    var itemRate = this.data.ratePgList[index];
    var pgId = itemRate.pgId;
    // var pgId = this.data.ratePgList[index].pgId;
    //console.log('取到的包体id：' + pgId);
    var url = '../confirmBuy/confirm-buy?pgId=' + pgId;
    url += '&rateId=' ;
    url += itemRate.rateId;
    url += '&chargeTel=' ;
    url += this.data.inputValue;
    url += '&pgPrice=' ;
    url += itemRate.pgPrice;
    url += '&pgSize=';
    url += itemRate.pgSize;
    url += '&pgDiscountPrice=' ;
    url += itemRate.pgDiscountPrice;

    wx.navigateTo({ url: url});
  },//
  // navigateBack:function () {
  //   wx.navigateBack()
  // },
  // redirectTo: function () {
  //   wx.redirectTo({
  //     url:'./navigator'
  //   })
  // }
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      // url: 'http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=' + e.detail.value, //仅为示例，并非真实的接口地址
      url: 'http://120.55.162.224/flowsys/wechat/init_first_page.do', //仅为示例，并非真实的接口地址
      data: {
        x: '',
        y: ''
      },
      header: {
        'content-type': 'application/json;charset=utf-8' // 默认值
      },
      success: function (res) {
        var serviceTypeEnums = res.data.serviceTypeEnums;
        that.setData({ serviceTypeEnums: serviceTypeEnums })
        // console.log(serviceTypeEnums);
        //console.log(res);
       // that.setData({ obj: carrier })
        // console.log(res.data)
      }
    })
  },
  getPhoneNumber: function (e) {
    console.log(e.detail.errMsg)
    console.log(e.detail.iv)
    console.log(e.detail.encryptedData)
  },
  // bindButtonTap: function () {
  //   this.setData({
  //     focus: true
  //   })
  // },
  bindKeyInput: function (e) {
    if (e.detail.value.length === 11) {
      var that = this;
      wx.request({
        // url: 'http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=' + e.detail.value, //仅为示例，并非真实的接口地址
        url: 'http://apis.juhe.cn/mobile/get?phone=' + e.detail.value+'&key=59b0973a9e6d8642b987ac04c1eb2c07', //仅为示例，并非真实的接口地址
        data: {
          x: '',
          y: ''
        },
        header: {
          'content-type': 'application/json;charset=utf-8' // 默认值
        },
        success: function (res) {
          var data = res.data;
          var provinceIn = data.result.province//广东
          var city = data.result.city
          var company = data.result.company//中国移动
          var carrier = provinceIn + city + company.substring(company.length - 2);
          //console.log(company.substring(company.length - 2))
          if ('' != data || null!=data){
            that.setData({ carrierIsNull: false });
            //console.log('空');
          }
          //console.log(carrier);
          that.setData({ carrier: carrier})
          // console.log(res.data)
        }
      })
      //收起键盘
      wx.hideKeyboard()
    }
    this.setData({
      inputValue: e.detail.value
    })
  },
  clickMe: function(e){
    var condition = this.data.condition
    // console.log(condition)
    this.setData({
      condition: !condition
    })
  }


  // bindReplaceInput: function (e) {
  //   var value = e.detail.value
  //   var pos = e.detail.cursor
  //   if (pos != -1) {
  //     // 光标在中间
  //     var left = e.detail.value.slice(0, pos)
  //     // 计算光标的位置
  //     pos = left.replace(/11/g, '2').length
  //   }

  //   // 直接返回对象，可以对输入进行过滤处理，同时可以控制光标的位置
  //   return {
  //     value: value.replace(/11/g, '2'),
  //     cursor: pos
  //   }

  //   // 或者直接返回字符串,光标在最后边
  //   // return value.replace(/11/g,'2'),
  // },
  // bindHideKeyboard: function (e) {
    
  //   if (e.detail.value === "123") {
  //     //收起键盘
  //     wx.hideKeyboard()
  //   }
  // }

  // bindLengthInput: function(e){
  //   if (e.detail.value === "123") {
  //     //收起键盘
  //     wx.hideKeyboard()
  //   }
  // }
})
