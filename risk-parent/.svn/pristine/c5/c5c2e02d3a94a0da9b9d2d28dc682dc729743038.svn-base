<template>
  <div class="bootstrap-table">
    <div class="fixed-table-container">
      <div class="fixed-table-body">
        <table class="table table-has-padding">
          <thead>
          <tr>
            <th width="200">关系</th>
            <th width="200">姓名</th>
            <th width="150">是否知晓</th>
            <th>移动号码</th>
            <th>单位名称</th>
          </tr>

          </thead>
          <tbody>
          <tr v-if="relations&&relations.length>0" v-for="(item, index) in relations">
            <td>
              <select :name="data.key+'_relation_'+index" v-model="item.relation"
                      class="form-control" :disabled="data.readonly?true:false">
                <option value="">请选择</option>
                <option v-for="rItem in oData[data.dataSource]" :value="rItem.dicKey">
                  {{rItem.dicValue}}
                </option>
              </select>
              <div class="form-error-tip" v-if="errorMsg[data.key+'_relation_'+index]">{{errorMsg[data.key+'_relation_'+index]}}</div>
            </td>
            <td>
              <input type="text" :name="data.key+'_name_'+index" class="form-control"
                     v-model="item.name" :disabled="data.readonly?true:false">
              <div class="form-error-tip" v-if="errorMsg[data.key+'_name_'+index]">{{errorMsg[data.key+'_name_'+index]}}</div>
            </td>
            <td>
              <div class="inline-radio">
                <label>
                  <input type="radio" :name="data.key+'_know_'+index" value="1" v-model="item.know"
                         :disabled="data.readonly?true:false">
                  <span>是</span>
                </label>
                <label>
                  <input type="radio" :name="data.key+'_know_'+index" value="0" v-model="item.know"
                         :disabled="data.readonly?true:false">
                  <span>否</span>
                </label>
              </div>
              <div class="form-error-tip" v-if="errorMsg[data.key+'_know_'+index]">{{errorMsg[data.key+'_know_'+index]}}</div>
            </td>
            <td>
              <input type="text" :name="data.key+'_phone_'+index" class="form-control"
                     v-model="item.fPhone" :disabled="data.readonly?true:false" @input="handleInput(index)" @blur="handleBlur(index)" @focus="handleFocus(index)">
              <div class="form-error-tip" v-if="errorMsg[data.key+'_phone_'+index]">{{errorMsg[data.key+'_phone_'+index]}}</div>
            </td>
            <td>
              <input type="text" :name="data.key+'_company_name_'+index" class="form-control"
                     v-model="item.company_name" :disabled="data.readonly?true:false">
              <div class="form-error-tip" v-if="errorMsg[data.key+'_company_name_'+index]">{{errorMsg[data.key+'_company_name_'+index]}}</div>
            </td>
          </tr>
          <tr v-else>
            <td colspan="5">
              没有记录
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
<style>
  .table-has-padding tr td {
    padding-top: 10px !important;
  }

  .table-has-padding tr th {
    padding-left: 10px !important;
  }
</style>
<script>
  import {mapGetters} from 'vuex';
  import * as api from '../api'
  import checkRule from '../mixins/checkRule'
  export default{
    mixins: [checkRule],
    data(){
      return {
        relations: [],
      }
    },
    created(){
      var initValue = this.init();
      this.relations=initValue
      var tempData={};
      for(let index in initValue){
        var arg=initValue[index];
        for(let key in arg){
          if(key!=='fPhone'){
            var inputKey=[this.data.key,key,index].join('_');
            tempData[inputKey]=arg[key]
          }
        }
      }
      this.$store.dispatch('setInputData',tempData);
      this.$watch('relations',this.handleWatchRelations,{deep:true})
    },
    beforeDestroy(){
      var args=this.relations;
      for(let index in args){
        var arg=args[index];
        for(let key in arg){
          this.delSubmitData(key)
        }
      }
    },
    methods: {
      init(){
        var temp = [];
        var key = this.data.key;
        for (var i = 0; i < 5; i++) {
          var opts = {};
          opts.relation = this.getDefaultValue(key + '_relation_' + i);
          opts.name = this.getDefaultValue(key + '_name_' + i);
          opts.know = this.getDefaultValue(key + '_know_' + i);
          opts.phone = this.getDefaultValue(key + '_phone_' + i);
          opts.fPhone = this.formatAccount(this.getDefaultValue(key + '_phone_' + i),'mobile');
          opts.company_name = this.getDefaultValue(key + '_company_name_' + i);
          temp.push(opts)
        }
        return temp;
      },
      handleInput(index){
        var e=e||window.event;
        var value=e.target.value;
        var relationItem=this.relations[index];
        relationItem.phone=this.unFormatAccount(value);
        relationItem.fPhone=this.formatAccount(value,'mobile')
        this.relations.splice(index,1,relationItem)
      },
      handleBlur(index) {
        var relationItem=this.relations[index];
        relationItem.fPhone=this.formatAccount(relationItem.phone,'mobile');
        this.relations.splice(index,1,relationItem)
      },
      handleWatchRelations(args){
        var tempData={};
        for(let index in args){
          var arg=args[index];
          for(let key in arg){
            if(key!=='fPhone'){
              var inputKey=[this.data.key,key,index].join('_');
              tempData[inputKey]=arg[key]
            }
          }
        }
        this.$store.dispatch('setInputData',tempData);
        this.checkRuleValue=Object.assign({},this.checkRuleValue,tempData)
      }
    }
  }
</script>
