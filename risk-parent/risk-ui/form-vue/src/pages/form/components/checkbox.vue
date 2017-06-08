<template>
  <div class="row-right"
       :class="oData[data.dataSource].length>4?'col-sm-12':(!checkedAdd?'col-sm-6':'col-sm-3')">
    <div class="form-group input-group " :id="data.key">
      <label class="label-head label-head-lg label-head-top  text-right" v-if="!checkedAdd"><span
        :class="data.required?'require':''">{{data.label}}:</span></label>
      <div class="label-box label-head-top">
        <app-checkbox-input v-for="item in oData[data.dataSource]" v-if="item" :type="'checkbox'"
                            :oData="item" :attrData="attrsData[data.key]" :data="data"
                            :checked="attrsData[data.key]|checkedFilter(item)"></app-checkbox-input>
        <div class="form-error-tip">{{errorMsg[data.key]}}</div>
      </div>
    </div>
  </div>
</template>
<style>
</style>
<script>
  import Input from './checkbox-input.vue'
  import checkRule from '../mixins/checkRule'
  export default{
    mixins: [checkRule],
    data(){
      return {
        checkBox: [],
        checked: ''
      }
    },
    props: ['data', 'oData', 'attrsData', 'checkedAdd'],
    created: function () {
      this.$store.dispatch('setInputData', {[this.data.key]:''})
    },
    watch: {
      checkBox: function (val) {
        var valStr = val.join(',');
        var valData={};
        valData[this.data.key]=valStr;
        this.checkRuleValue=Object.assign({},this.checkRuleValue,valData);
        this.$store.dispatch('setInputData', {[this.data.key]:valStr})
      }
    },
    filters: {
      checkedFilter: function (v, item) {
        //默认选中后操作
        if (v) {
          var dicKey = item.dicKey;
          var attrValue = v;
          var attrData = attrValue ? (attrValue.draftValue == null ? (attrValue.attrValue || '') : attrValue.draftValue) : '';
          var attrArr = attrData.split(',');
          var filterValue='';
          for(let key in attrArr){
            var itemValue=attrArr[key];
            if(itemValue==dicKey){
              filterValue=itemValue;
              break;
            }
          }
          return filterValue
        }
      }
    },
    components: {
      'app-checkbox-input': Input,
    },
  }
</script>
