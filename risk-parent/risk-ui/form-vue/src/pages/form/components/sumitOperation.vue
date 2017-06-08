<template>
  <div class=" btn-right" >
    <div v-for="item in buttonData" class="btn btn-primary btn-primary-lg"  :id="item.key"
            @click="handleClick(item)">{{item.name}}
    </div>
  </div>
</template>
<style>
  .btn-center {
    vertical-align: middle;
    text-align: center;
    margin: 40px 0;
  }
  .btn-right{
    vertical-align: middle;
    text-align: right;
    padding:10px;
  }
  .btn-center .btn ,.btn-right .btn{
    margin-left: 20px;
  }

  .btn-submit {
    padding-left: 50px;
    padding-right: 50px;
  }
</style>
<script>
  import {mapGetters} from 'vuex'
  import * as api from '../api'
  export default{
    data(){
      return {
        isClick:[]
      }
    },
    computed: {
      ...mapGetters({
        'buttonData':'buttonData',
        'hiddenData': 'defaultHiddenData',
        'rulesData': 'rulesData'
      })
    },
    methods: {
      handleClick: function (args) {

        var _this=this;
        var hiddenData = this.hiddenData;
        var submitData = this.$store.state.submitData;
        var params = {}
        $.extend(params, hiddenData, {data: JSON.stringify(submitData)});
        var options = {
          url: args.url,
          method:args.method,
          data: params,
          beforeSend:function () {
            _this.isClick[args.key]=true;
            _this.changeShow('submit_form',true)
          },
          complete: function () {
            _this.isClick[args.key]=false;
            _this.changeShow('submit_form',false)
          }
        };
        var canSubmit = false;
        if (!args.validate) {
          canSubmit = true;
        } else {
          canSubmit = this.checkRules();
        }
        if (canSubmit&&!this.isClick[args.key]) {
          api.submitFormData(options, function () {
            $.showPop(args.name + '成功','',3000);
            setTimeout(function () {
              var url=tools.getCurrentIFrameUrl();
              var refreshUrl=tools.www_root()+'/index/toIndex';
              tools.closeParentTab(url,refreshUrl)
            },2000)

          })
        }

      },
      checkRules: function () {
//          condition是第一层判断，ruleType是第二层判断，然后才是下面的判断
        var postParams = this.$store.state.submitData;
        var rules = this.rulesData;
        var canSubmit = true;
        var message = '';//验证报错弹框信息
        let fieldDomKey = '';//具体验证错误的验证key
        var operationType=postParams.operationType;
        if(operationType==null||operationType=='undefined'||operationType==1){
          for (var key in postParams) {
            var oneFlag = false;
            var status = this.hasEmpty(rules[key],postParams);
            var postValue = postParams[key];
            var rule = rules[key];
            if (status == 1) {
              //必须有值
              if (rule) {
                statValidate(rule)
              }
            }
            else if (status == 2) {
              if (postValue) { //有没有值，有值才
                if (rule) {
                  statValidate(rule)
                }
              }
            }

            if (oneFlag) {
//              console.info('++id',fieldDomKey)
              /*var fieldDomKeyDom = $('#' + fieldDomKey)[0]||$('.'+fieldDomKey)[0];
              var $fieldDomKey=$(fieldDomKeyDom);*/
              var $focusDom = $('[name="'+fieldDomKey+'"]');
//              $fieldDomKey.addClass('.has-error');
              var key=$focusDom.parents('.tab-item-content').index();
              $('.tab-item').eq(key).click();
              var errData={};
              errData[fieldDomKey]=message;
              this.$store.dispatch('setError',errData);
              $.showPop(message,'',3000);
             var focusTimer= setTimeout(function () {
               $focusDom.focus();
               clearTimeout(focusTimer);
               focusTimer=null;
              },1100);
              break;
            }
          }
          return canSubmit;
        }else{
          canSubmit=true;
          return canSubmit;
        }

        //验证函数
        function statValidate(rule) {
          for (var key1 in rule) {
            var twoFlag = false;
            var v1 = rule[key1];
            //特殊ruleType规则
            var ruleType = v1.ruleType;
            if (ruleType == 'notEmpty') {
              if (!/\S/.test(postValue)) {
                twoFlag = true;
                message = (v1.fieldName || '') + '不能为空';
                fieldDomKey = v1.parent||v1.fieldKey;
                canSubmit = false;
              }
            }
            if (tools.rules.hasOwnProperty(ruleType)) {
              var toolsRule = tools.rules[ruleType];
              if (new RegExp(toolsRule.reg).test(postValue)) {
//                    canSubmit = true;
              } else {
                canSubmit = false;
                twoFlag = true;
                message = (v1.fieldName || '') + toolsRule.message;
                fieldDomKey = v1.parent||v1.fieldKey;
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
                    if(!/^(-?\d+)(\.\d+)?$/.test(postValue)){
                      twoFlag = true;
                      message = (v1.fieldName || '') + v1.message;
                      fieldDomKey = v1.parent||v1.fieldKey;
                      canSubmit = false;
                      break;
                    }
                    dValue=parseFloat(dValue);
                    //最小值
                    if (dKey == 'min') {
                      if (postValue < dValue) {
                        twoFlag = true;
                        message = (v1.fieldName || '') + v1.message;
                        fieldDomKey = v1.parent||v1.fieldKey;
                        canSubmit = false;
                        break;
                      }
                    }
                    //最大值
                    if (dKey == 'max') {
                      if (postValue > dValue) {
                        twoFlag = true;
                        message = (v1.fieldName || '') + v1.message;
                        fieldDomKey = v1.parent||v1.fieldKey;
                        canSubmit = false;
                        break;
                      }
                    }
                    //小数
                    postValue=postValue.toString();
                    var digitsValue=postValue.split(".")[1]||'';
                    var digitsLen = digitsValue.length;
                    if (dKey == 'digits') {
                      if (digitsLen > dValue) {
                        twoFlag = true;
                        message = (v1.fieldName || '') + v1.message;
                        fieldDomKey = v1.parent||v1.fieldKey;
                        canSubmit = false;
                        break;
                      }
                    }
                  } else {
                    //字符串
                    //长度
                    var len = postValue && postValue.toString().length;
                    //最小值
                    if (dKey == 'min') {
                      if (len < dValue) {
                        twoFlag = true;
                        message = (v1.fieldName || '') + '最小长度为' + dValue;
                        fieldDomKey = v1.parent||v1.fieldKey;
                        canSubmit = false;
                        break;
                      }
                    }
                    //最大值
                    if (dKey == 'max') {
                      if (len > dValue) {
                        twoFlag = true;
                        message = (v1.fieldName || '') + '最大长度为' + dValue;
                        fieldDomKey = v1.parent||v1.fieldKey;
                        canSubmit = false;
                        break;
                      }
                    }
                  }
                  //正则
                  if (dKey == 'regexp') {
                    if (!new RegExp(dValue).test(postValue)) {
                      twoFlag = true;
                      message = (v1.fieldName || '') + v1.message;
                      fieldDomKey = v1.parent||v1.fieldKey;
                      canSubmit = false;
                      break;
                    }
                  }
                }
              }
            }

            if (twoFlag) {
              oneFlag = true;
              break;
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
          return 4;
        }


        var flag = false;
        for (var k in rules) {
          var rule = rules[k];
          if (rule.ruleType == 'notEmpty') {
            flag = true;
            break;
          }
        }
        return flag;
      },
      changeShow(key,value){
        this.$store.dispatch('showLoad',{[key]:value});
      }
    }
  }
</script>
