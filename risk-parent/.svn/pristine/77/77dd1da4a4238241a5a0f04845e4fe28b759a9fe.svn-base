<template>
  <div class="bootstrap-table">
    <div class="fixed-table-container">
      <div class="fixed-table-body">
        <table class="table table-has-padding">
          <thead>
          <tr>
            <th width="200">来源</th>
            <th >征信内容</th>
            <th width="200">征信链接</th>
            <th width="200">征信结论</th>
          </tr>

          </thead>
          <tbody>
          <tr v-if="credits&&credits.length>0" v-for="(item, index) in credits">
            <td>
              {{item.resource}}
            </td>

            <td>
              {{item.content}}
            </td>
            <td>
              <a :href="item.url" target="_blank">查看</a>
            </td>
            <td>
              <input type="text" :name="data.key+'_result_'+index" class="form-control"
                     v-model="input[index]" :disabled="data.readonly?true:false" style="margin-top:5px">
              <div class="form-error-tip" v-if="errorMsg[data.key+'_result_'+index]">{{errorMsg[data.key+'_result_'+index]}}</div>
            </td>
          </tr>
          <tr v-else>
            <td colspan="4">
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
        input:[]
      }
    },
    created(){
      this.getCreditsData();
      this.$watch('credits',this.handleWatchCredits,{deep:true})
    },
    computed:{
      ...mapGetters({
        'creditsData':'creditsData',
        'hiddenData': 'defaultHiddenData',
      }),
      credits(){
        var creditsData=this.creditsData;
        for(var index in creditsData){
          var item=creditsData[index];
          var result=this.input[index]||this.getDefaultValue(this.data.key+'_result_'+index);
          this.input.splice(index,1,result)
          item.result=result;
        }
        return creditsData;
      }
    },
    methods: {
      getCreditsData(){
        var _this=this;
        var options={
          url:'/credit/attrInfo',
          method:'get',
          beforeSend(){
            _this.$store.dispatch('showLoad',{[_this.data.key]:true});
          },
          success(){
            _this.$store.dispatch('showLoad',{[_this.data.key]:false});
          }
        };
        _this.$store.dispatch('getCreditsData',options);
      },
      handleWatchCredits(args){
        var tempData={};
        for(let index in args){
          var arg=args[index];
          for(let key in arg){
            if(key=='result'){
              var inputKey=[this.data.key,key,index].join('_');
              tempData[inputKey]=arg[key]
            }
          }
        }
        this.$store.dispatch('setInputData',tempData);
        this.checkRuleValue=Object.assign({},this.checkRuleValue,tempData)
      }
    },
    beforeDestroy(){
      var args=this.credits;
      for(let index in args){
        var arg=args[index];
        for(let key in arg){
          this.delSubmitData(key)
        }
      }
    },
  }
</script>
