<template>
  <div class="row-right" :class="!checkedAdd?'col-sm-6':'col-sm-3'">
    <div class="form-group input-group " :id="data.key">
      <label class="label-head label-head-lg label-head-top  text-right"  v-if="!checkedAdd"><span :class="data.required?'require':''">{{data.label}}:</span></label>
      <div class="label-box label-box-sm">
         <span class="input-group date" :id="data.key+'_input'" >
      <input :name="data.key" class="form-control" type="text" readonly v-model="dateTime">
      <span class="input-unit add-on"><i class="fa fa-angle-down"></i></span>
    </span>
        <div class="form-error-tip">{{errorMsg[data.key]}}</div>
      </div>
    </div>


  </div>

</template>
<style>
</style>
<script>
  import checkRule from '../mixins/checkRule'
  export default{
    mixins:[checkRule],
    data(){
      return {
        dateTime:'',
        datetimepicker:{}
      }
    },
    props: ['data','attrsData','checkedAdd'],
    created:function () {
      var attrValue=this.attrsData[this.data.key]||{};
      var value=attrValue ? (attrValue.draftValue==null?(attrValue.attrValue||''):attrValue.draftValue) : '';
      this.dateTime=value;
      this.$store.dispatch('setInputData', {[this.data.key]: value});
    },
    mounted: function () {
      var _this=this;
      var dom = '#' + this.data.key+'_input';
      if(!datetimepicker&&!this.data.readonly){
        var datetimepicker=$(dom).datepicker({
          format: 'yyyy-mm-dd',
          autoclose:true,
          todayBtn:'linked',
          todayHighlight:true,
          language:'zh-CN',
        },function (date) {
          _this.dateTime=date;
        });
        this.datetimepicker=datetimepicker;
      }

    },
    watch:{
      dateTime:function (val) {
        var valData={};
        valData[this.data.key]=val;
        this.checkRuleValue=Object.assign({},this.checkRuleValue,valData);
        this.$store.dispatch('setTimeDate',{key:this.data.key,value:val})
      }
    }
  }
</script>
