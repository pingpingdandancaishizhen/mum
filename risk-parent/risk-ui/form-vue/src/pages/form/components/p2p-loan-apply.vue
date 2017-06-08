<template>
  <div v-if="loanData">
    <div class="col-sm-6 row-right " >
      <div class="form-group input-group" :id="data.key+'_amount'">
        <label class="label-head label-head-lg label-head-top  text-right"><span
          :class="data.required?'require':''">借款金额:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_amount'" class="form-control" v-model="loadApply[data.key+'_amount']" :disabled="data.readonly?true:false" @change="getFeeData">
          <div class="form-error-tip">{{errorMsg[data.key+'_amount']}}</div>
        </div>
        <div class="label-unit">元</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " >
      <div class="form-group input-group" :id="data.key+'_apply_repaymentTypes'">
        <label class="label-head label-head-lg label-head-top  text-right"><span
          :class="data.required?'require':''">借款人还款方式:</span></label>
        <div class="label-box label-box-sm">
          <select :name="data.key+'_apply_repaymentTypes'" class="form-control" v-model="loadApply[data.key+'_apply_repaymentTypes']" :disabled="data.readonly?true:false">
            <option value="">请选择</option>
            <option v-for="item in loanData" :value="item.repaymentType">{{item.repaymentTypeName}}</option>
            </select>
          <div class="form-error-tip">{{errorMsg[data.key+'_apply_repaymentTypes']}}</div>
        </div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loanData[loadApply[data.key+'_apply_repaymentTypes']]">
      <div class="form-group input-group" :id="data.key+'_apply_monthlyTerm'">
        <label class="label-head label-head-lg label-head-top  text-right"><span
          :class="data.required?'require':''">借款期限:</span></label>
        <div class="label-box label-box-sm">
          <select :name="data.key+'_apply_monthlyTerm'" class="form-control" v-model="loadApply[data.key+'_apply_monthlyTerm']" :disabled="data.readonly?true:false" @change="getFeeData">
            <option value="">请选择</option>
            <option v-if="loanData[loadApply[data.key+'_apply_repaymentTypes']].terms" v-for="item in loanData[loadApply[data.key+'_apply_repaymentTypes']].terms" :value="item.termName">{{item.termName}}</option>
            </select>
          <div class="form-error-tip">{{errorMsg[data.key+'_apply_monthlyTerm']}}</div>
        </div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_monthlyRate']">
      <div class="form-group input-group" :id="data.key+'_monthlyRate'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>利息/月:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_monthlyRate'" class="form-control" v-model="loadApply[data.key+'_monthlyRate']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_daylyRate']" >
      <div class="form-group input-group" :id="data.key+'_daylyRate'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>利息/日:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_daylyRate'" class="form-control" v-model="loadApply[data.key+'_daylyRate']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_monthlyGLFee']">
      <div class="form-group input-group" :id="data.key+'_monthlyGLFee'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>管理费/月:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_monthlyGLFee'" class="form-control" v-model="loadApply[data.key+'_monthlyGLFee']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_daylyGLFee']">
      <div class="form-group input-group" :id="data.key+'_daylyGLFee'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>管理费/日</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_daylyGLFee'" class="form-control" v-model="loadApply[data.key+'_daylyGLFee']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_yearlyRate']">
      <div class="form-group input-group" :id="data.key+'_yearlyRate'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>年化率:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_yearlyRate'" class="form-control" v-model="loadApply[data.key+'_yearlyRate']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_znjFee']">
      <div class="form-group input-group" :id="data.key+'_znjFee'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>滞纳金率:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_znjFee'" class="form-control" v-model="loadApply[data.key+'_znjFee']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right " v-if="loadApply[data.key+'_wyFee']">
      <div class="form-group input-group" :id="data.key+'_wyFee'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>违约金率:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_wyFee'" class="form-control" v-model="loadApply[data.key+'_wyFee']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit">%</div>
      </div>
    </div>
    <div class="col-sm-6 row-right "  v-if="loadApply[data.key+'_otherFee']">
      <div class="form-group input-group" :id="data.key+'_otherFee'">
        <label class="label-head label-head-lg label-head-top  text-right">
          <span>其他费用:</span></label>
        <div class="label-box label-box-sm">
          <input :name="data.key+'_otherFee'" class="form-control" v-model="loadApply[data.key+'_otherFee']" disabled="disabled">
          <div class="form-error-tip"></div>
        </div>
        <div class="label-unit" >元</div>
      </div>
    </div>
  </div>
</template>
<style>

</style>
<script>
  import {mapGetters} from 'vuex';
  import checkRule from '../mixins/checkRule'
  import {getFeeData} from '../api/index';
  const defaultkey=[
    'amount',
    'apply_repaymentTypes',
    'apply_monthlyTerm',
    'monthlyRate',
    'daylyRate',
    'yearlyRate',
    'monthlyGLFee ',
    'daylyGLFee',
    'znjFee',
    'wyFee',
    'otherFee',
  ];
    export default{
      mixins:[checkRule],
        data(){
            return{
              loadApply:{}
            }
        },
      created(){
          var _this=this;
        var readonly=_this.data.readonly;
        var attrsData = this.attrsData;
        for(let i in defaultkey){
          var data_key=[_this.data.key,defaultkey[i]].join('_');
          var deAttrDataValue='';
          if(readonly||defaultkey[i]=='amount'){
            var attrValue = attrsData[data_key];
            deAttrDataValue = attrValue ? (attrValue.draftValue == null ? (attrValue.attrValue || '') : attrValue.draftValue) : '';
          }
          this.$set(this.loadApply, data_key, deAttrDataValue)
          }
        _this.getLoanData();
        _this.$watch('loadApply',this.watchLoadApply,{deep:true})
      },
      computed:{
        ...mapGetters({
          'loanData':'loanData',
          'hiddenData': 'defaultHiddenData',
        }),
      },
      methods:{
        getLoanData(){
          var _this=this;
          var options={
            url:'/order/loanInfoPlugin',
            method:'post',
            data:{
              productCode:_this.hiddenData.productId
            },
            beforeSend(){
              _this.$store.dispatch('showLoad',{[_this.data.key+'_loan_data']:true});
            },
            success(){
              _this.$store.dispatch('showLoad',{[_this.data.key+'_loan_data']:false});
            }
          };
          _this.$store.dispatch('getLoanData',options);
        },
        getFeeData(){
          var _this=this;
          var readonly=_this.data.readonly;
          var _amount=_this.loadApply[_this.data.key+'_amount'],
            /*_apply_repaymentTypes=_this.loadApply[_this.data.key+'_apply_repaymentTypes'],*/
            _apply_monthlyTerm=_this.loadApply[_this.data.key+'_apply_monthlyTerm'];
          if(_amount&&_apply_monthlyTerm&&!readonly){
              var options={
                url:'/order/getRates',
                data:{
                  termText:_apply_monthlyTerm,
                  loanMoney:_amount,
                  productCode:_this.hiddenData.productId
                },
                method:'post',
                beforeSend(){
                  _this.$store.dispatch('showLoad',{[_this.data.key+'_fee_data']:true});
                },
                complete(){
                  _this.$store.dispatch('showLoad',{[_this.data.key+'_fee_data']:false});
                },
                success(res){
                  if(res&&res.status!=1){
                    var reDefaultData={
                      'monthlyRate':'',
                      'daylyRate':'',
                      'yearlyRate':'',
                      'monthlyGLFee':'',
                      'daylyGLFee':'',
                      'znjFee':'',
                      'wyFee':'',
                      'otherFee':'',
                    };
                    var temp={}
                    for(let k in reDefaultData){
                      var key=[_this.data.key,k].join('_');
                      temp[key]=reDefaultData[k];
                    }
                    _this.loadApply=Object.assign({},_this.loadApply,temp)
                  }
                }
              };
            getFeeData(options,function (data) {
              _this.loadApply=Object.assign({},_this.loadApply,data)
            })
          }

        },
        watchLoadApply(val){
          this.checkRuleValue=Object.assign({},this.checkRuleValue,val);
          this.$store.dispatch('setInputData', val);
        }
      },
    }
</script>
