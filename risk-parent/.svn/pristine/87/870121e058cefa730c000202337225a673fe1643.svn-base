<template>
<div>
  <div class="form-head">
    <app-submit v-if="!view&&buttonData" ></app-submit>
    <div class="tabs-nav">
      <div class="tab-item" v-for="item,key in data" v-if="item.tabName" :class="key==activeKey?'active':''" @click="handleChangeTabs(key)">
        <span>{{item.tabName}}</span>
      </div>
    </div>
  </div>
  <div class="tabs-content" :style="{marginTop:buttonData?'117px':'64px'}">
      <div class="tab-item-content" v-for="item,key in data" :class="key==activeKey?'active':'tab-pane'">
        <app-form v-if="item.tabList" :data="item.tabList"    ></app-form>
        <div class="col-md-12" v-if="item.handle&&!view&&operationsData&&operationsData.length>0">
          <div class="sub-head">
            审核意见：
          </div>
          <div class="panel panel-default" :id="item.key">
            <div class="panel-body form-label-auto">
              <app-operations  :data="operationsData" ></app-operations>
            </div>
          </div>
        </div>
      </div>
  </div>
</div>
</template>
<script>
    import {mapGetters} from 'vuex'
    import Form from './form.vue'
    import submitOperation  from './sumitOperation.vue'
    import Operations  from './operations.vue'
    export default{
        data(){
            return{
//              activeKey:0
            }
        },
      props:['activeKey','data'],
      components: {
        'app-form':Form,
        'app-submit': submitOperation,
        'app-operations': Operations,
      },
      computed: {
        ...mapGetters({
          'view':'view',
          'operationsData': 'operationsData',
          'buttonData':'buttonData',
        }),

      },
      methods:{
        handleChangeTabs:function (key) {
          /*this.activeKey=key;*/
          this.$emit('changeTab',key)
        },

      }
    }
</script>
