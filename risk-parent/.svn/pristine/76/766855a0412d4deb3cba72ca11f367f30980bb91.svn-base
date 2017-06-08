<template>
  <div class="col-md-12">
    <div class="form-group" >
      <div class="input-group">
        <label class="label-head label-head-lg label-head-top  text-right" ><span class="require">审核意见:</span></label>
        <div class="label-box">
          <div class="inline-block" v-for="(item,key) in data">
            <label class="radio-inline " >
              <input type="radio" name="operation" :value="item.operation" v-model="checkedValue">
              <span>{{item.operationName}}</span>
            </label>
          </div>

        </div>

      </div>

    </div>
    <div class="form-group">
      <div class="input-group">
        <label class="label-head label-head-lg label-head-top  text-right" ><span class="require">意见原因：</span></label>
        <div class="label-box" style="width: 500px">
          <textarea onpropertychange="if(value.length>100) value=value.substr(0,100)" name="reason" class="form-control" rows="3" @change="handleTextChange"></textarea>
      </div>

      </div>
    </div>
  </div>

</template>
<style>

</style>
<script>
  import { mapGetters } from 'vuex';
    export default{
        data(){
            return{
              checkedValue:''
            }
        },
      props:['data'],
      created:function () {
          for(var key in this.operationData){
            var v=this.operationData[key];
            if(v.operationType==1){
              this.checkedValue=key;
            }
          }

      },
      computed:{
        operationData(){
          var temp={};
          for(var key in this.data){
            var v=this.data[key];
            temp[v.operation]=v;
          }
          return temp
        },
      },
      methods:{
        handleTextChange:function (e) {
          var $el=$(e.target);
          var value=$el.val();
          if(value.length>100) value=value.substr(0,100);
          $el.val(value);
          this.$store.dispatch('setInputData', {'reason': value})
        }
      },
      watch:{
        checkedValue(val){
          this.$store.dispatch('setInputData', {'operation':val,'operationType':this.operationData[val].operationType})
        }
      }
    }
</script>
