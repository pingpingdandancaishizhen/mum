/**
 * Created by RJS on 2017/4/27.
 */
import {mapGetters} from 'vuex';
export default {
  data() {
    return {
      checkRuleValue:{},
    }
  },
  props: ['data','oData','attrsData','ruleData','checkedAdd'],
  computed: {
    ...mapGetters({
      'errorMsg': 'errorMsg',
    })
  },
  watch:{
    checkRuleValue:{
      handler(val){
        var error={};
        for(var key in val){
          var item=val[key];
          var message=(this.checkRules(item,key))
          error[key]=message;
        }
        this.$store.dispatch('setError',error)
      },
      deep:true
    },
    // data:{
    //   handler(val,oldVal){
    //     if(val.key!==oldVal.key){
    //       console.log(this)
    //     }
    //   }
    // }
  },
  methods:{
    checkRules: function (val,key) {
//          condition是第一层判断，ruleType是第二层判断，然后才是下面的判断
      var postParams = this.$store.state.submitData;
      var rules = this.ruleData[key];
      var canSubmit = true;
      var message = '';//验证报错弹框信息
      var status = this.hasEmpty(rules,postParams);
      // console.log('status',key,status)
      if (status == 1) {
        //必须有值
        if (rules) {
          statValidate(rules)
        }
      }
      else if (status == 2) {
        if (val) { //有没有值，有值才
          if (rules) {
            statValidate(rules)
          }
        }
      }
      return message;
      //验证函数
      function statValidate(rule) {
        for (var key1 in rule) {
          var twoFlag = false;
          var v1 = rule[key1];
          //特殊ruleType规则
          var ruleType = v1.ruleType;
          if (ruleType == 'notEmpty') {
            if (!/\S/.test(val)) {
              twoFlag = true;
              message = v1.message;
              canSubmit = false;
            }
          }
          if (tools.rules.hasOwnProperty(ruleType)) {
            var toolsRule = tools.rules[ruleType];
            if (new RegExp(toolsRule.reg).test(val)) {
//                    canSubmit = true;
            } else {
              canSubmit = false;
              twoFlag = true;
              message =  toolsRule.message;
            }
          }
          //具体的校验规则
          if (!twoFlag) {
            var detail = v1.detail;
            if (detail) {
              for (var dKey in detail) {
                var dValue = detail[dKey];
                //数字判断
                if (ruleType=='integer'||ruleType=='decimal') {
                  if(!/^(-?\d+)(\.\d+)?$/.test(val)){
                    twoFlag = true;
                    message = v1.message;
                    canSubmit = false;
                    break;
                  }
                  dValue=parseFloat(dValue);
                  //最小值
                  if (dKey == 'min') {
                    if (val < dValue) {
                      twoFlag = true;
                      message = v1.message;
                      canSubmit = false;
                      break;
                    }
                  }
                  //最大值
                  if (dKey == 'max') {
                    if (val > dValue) {
                      twoFlag = true;
                      message = v1.message;
                      canSubmit = false;
                      break;
                    }
                  }
                  //小数
                  val=val.toString();
                  var digitsValue=val.split(".")[1]||'';
                  var digitsLen = digitsValue.length;
                  if (dKey == 'digits') {
                    if (digitsLen > dValue) {
                      twoFlag = true;
                      message =v1.message;
                      canSubmit = false;
                      break;
                    }
                  }
                } else {
                  //字符串
                  //长度
                  var len = val && val.toString().length;
                  //最小值
                  if (dKey == 'min') {
                    if (len < dValue) {
                      twoFlag = true;
                      message = '最小长度为' + dValue;
                      canSubmit = false;
                      break;
                    }
                  }
                  //最大值
                  if (dKey == 'max') {
                    if (len > dValue) {
                      twoFlag = true;
                      message =  '最大长度为' + dValue;
                      canSubmit = false;
                      break;
                    }
                  }
                }
                //正则
                if (dKey == 'regexp') {
                  if (!new RegExp(dValue).test(val)) {
                    twoFlag = true;
                    message =  v1.message;
                    canSubmit = false;
                    break;
                  }
                }
              }
            }
          }
        }
      }
    },
    hasEmpty: function (rules,postParams) {
      if (rules && rules.length > 0) {
        var has = false;
        var emptyrule;
        for (var rulekey in rules) {
          var rule = rules[rulekey];
          if (rule.ruleType == 'notEmpty') {
            has = true;
            emptyrule = rule;
            break;
          }
        }
        if (has) {
          var condition = emptyrule.condition;
          var conditionFlag;
          if (condition && condition.length > 0) {
            for (var k2 in condition) {
              var v2 = condition[k2];
              var bindingKeyValue = postParams[v2.fieldKey];
              if(bindingKeyValue){
                var evalOperation=bindingKeyValue+v2.operator+v2.value;
                /*console.log('eval',evalOperation)*/
                if (eval(evalOperation)) {
                  conditionFlag = true;
                } else {
                  conditionFlag = false;
                  break;
                }
              }else{
                conditionFlag=true;
              }

            }
            if (conditionFlag) {
              return 1;
            } else {
              //不符合CONDITOIN
              return 4;
            }
          } else {
            //必须验证
            return 1;
          }
        } else {
          //没有NOTEMPTY
          return 2;
        }
      } else {
        //没有rules
        return 5;
      }
    },
    formatAccount:function (value,type) {
      var fValue='';
      if(type=='account'){
        fValue=value.replace(/\s/g,'').replace(/([0-9a-zA-Z]{4})(?=[0-9a-zA-Z])/g,"$1 ")
      }
      if(type=='mobile'){
        fValue=value.replace(/\D|\s/g,'').replace(/(\d{3})(\d{0,4})/,"$1 $2 ")
      }
      if(type=='IDAccount'){
        fValue=value.replace(/\s/g,'').replace(/(\d{6})(\d{0,4})(\d{0,4})/,"$1 $2 $3 ")
      }
      if(type=='amount'){
        var rex = /\d{1,3}(?=(\d{3})+$)/g;
        fValue= value.replace(/,/g,'').replace(/^(-?)(\d+)((\.\d+)?)$/, function (s, s1, s2, s3) {
          return s1 + s2.replace(rex, '$&,') + s3;
        })
      }
      return fValue;
    },
    unFormatAccount(value){
      return value.replace(/\s|,/g,'')
    },
    getDefaultValue(key){
      var attrValue = this.attrsData[key] || {};
      return attrValue ? (attrValue.draftValue == null ? (attrValue.attrValue || '') : attrValue.draftValue) : '';
    },
    delSubmitData(key){
     this.$store.dispatch('delInputData',key)
    }
  },
  beforeDestroy(){

    this.delSubmitData(this.data.key);
    var binding=this.data.binding;
    if(binding){
      var bindingArr=binding.split(',');
      for(var i in bindingArr){
        var key=bindingArr[i];
        this.delSubmitData(key);
      }
    }
  },
}
