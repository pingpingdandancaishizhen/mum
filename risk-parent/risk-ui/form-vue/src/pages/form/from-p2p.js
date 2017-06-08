/**
 * Created by RJS on 2016/12/28.
 */
import "babel-polyfill";
import Vue from 'vue';
import VueX from 'vuex';
import store from './store'

import app from './components/app.vue';
Vue.use(VueX);
$(document).ready(function () {
  new Vue({
    el: '#app',
    store,
    data: {
    },
    created: function () {
      var formDataParams=tools.getqueryParams();
      var api= {
        // 获取要填充的表单数据
        formDataOpts: {
          url: '/order/getFormData',
          method: 'get',
          data: formDataParams
        },
        optionDataOpts:{
          url: '/data/datadic',
          method: 'get',
          data: {
            type:''
          },//后期添加
        }
      };
      //获取表单数据
      this.$store.dispatch('getAllFormData',api);
    },
    template: '<app />',
    components: {
      'app': app
    },

  });
})


