<template>
  <div >
    <div v-if="data">
      <app-tab :data="data" :activeKey="activeKey"  @changeTab="changeMenu"></app-tab>
    </div>
    <app-loading v-if="show" ></app-loading>
  </div>

</template>
<style>
  body {
    background: #f7f8fd;
  }
  .content{
    min-height:100%;
  }
  .form-error-tip {
    font-size: 12px;
    color: #fd6b91;
    height:18px;
    width: 100%;
    float: left;
    margin-top:5px;
  }
  .form-loading{
    position: fixed;
    height:100%;
    width: 100%;
    z-index: 99999999;
    top:0;
    left:0;
  }
  .form-loading .loading-content{
    width: 60px;
    height:60px;
    margin:auto;
    padding:10px 0;
    position: absolute;
    vertical-align: middle;
    text-align: center;
    top:0;
    right:0;
    bottom:0;
    left:0;
    background: #000;
    color:#fff;
    opacity:.85;
    border-radius: 15px;
  }
  .form-head{
    position: fixed;
    top:0;
    left:0;
    width: 100%;
    z-index: 9999;
    background: #fff;
  }
</style>
<script>
  import {mapGetters} from 'vuex'
  import Tab  from './tab.vue'
  import Loading  from './loading.vue'
  //  import Operations  from './operations.vue'
  /*import submitOperation  from './sumitOperation.vue'*/
  import Menu from  './menu.vue'
  export default{
    data(){
      return {
        top: 0,
        tabKey: '',
        menu: '',
//        show:false
      }
    },
    computed: {
      ...mapGetters({
        'data': 'formData',
        'operationsData': 'operationsData',
        'view': 'view',
        'showLoad':'showLoad'
      }),
      activeKey(){
       /* console.log('key---',this.data)*/
        return this.tabKey===''? this.getDeActiveKey():this.tabKey;
      },
      show(){
        var showLoad=this.showLoad;
       var show=false;
        for(let key in showLoad){
          var item=showLoad[key];
          show=show||item;
        }
        return show;
      }
    },
    components: {
      'app-tab': Tab,
//      'app-operations': Operations,
//      'app-submit': submitOperation,
//      'app-menu': Menu,
      'app-loading': Loading,
    },
    methods: {
      changeMenu(a) {
        this.tabKey = a;
      },
      getDeActiveKey:function () {
        var _this=this;
        var flag=false;
        var activeKey='0';
        for(var key in _this.data){
          var item=_this.data[key];
          if(item.handle){
            flag=true;
            activeKey=key;
            break;
          }
        }
        return activeKey;
      },
    }
  }
</script>
