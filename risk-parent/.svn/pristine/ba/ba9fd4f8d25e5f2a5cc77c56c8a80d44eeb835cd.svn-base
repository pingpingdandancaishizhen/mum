<template>
  <div class="row-right" :class="!checkedAdd?'col-sm-5':'col-sm-3'">
    <div class="form-group input-group " :id="data.key">
      <label class="label-head label-head-lg label-head-top  text-right"  v-if="!checkedAdd"><span :class="data.required?'require':''">{{data.label}}:</span></label>
      <div class="label-box">
        <input class="form-control" type="text" :id="data.key+'_input'">
        <input class="hiddenInput" type="text" :name="data.key+'_brand'" >
        <input class="hiddenInput" type="text" :name="data.key+'_series'" >
        <input class="hiddenInput" type="text" :name="data.key+'_model'" >
        <input class="hiddenInput" type="text" :name="data.key" >
        <div class="form-error-tip">{{errorMsg[data.key+'_brand']||errorMsg[data.key+'_series']||errorMsg[data.key+'_model']}}</div>
      </div>
    </div>
  </div>
</template>
<script>
  import {mapGetters} from 'vuex';
  import * as api from '../api';
  import checkRule from '../mixins/checkRule'
  export default{
    mixins:[checkRule],
    data(){
      return {
        position: {},
        cityPicker: "",
        carData:''
      }
    },
    props: ['data','attrsData','checkedAdd'],
    created:function () {
      var binding=this.data.binding||'';
      var bindingArr=binding.split(',');
      var inputData={};
      for(var i in bindingArr){
        var item=bindingArr[i];
        var attrValue=this.attrsData[item]||{};
        var value=attrValue ? (attrValue.draftValue==null?(attrValue.attrValue||''):attrValue.draftValue) : '';
        inputData[item]=value;
        this.$set(this.position,item,value);
      }
      this.$store.dispatch('setInputData', inputData);
//      this.setbands();
      this.$watch('position',this.setbands,{deep:true});
      this.getCar300Data()
    },
    methods: {
      setbands:function () {
        var binding=this.data.binding||'';
        var bindingArr=binding.split(',');
        var position=this.position;
        var addArr={};
        var positionDetail=[];
        var key=this.data.key;
        addArr[key+'_brand']=position[key+'_brand']||"";
        addArr[key+'_series']=position[key+'_series']||"";
        addArr[key+'_model']=position[key+'_model']||"";
        for(var index in bindingArr) {
          var item = bindingArr[index];
          positionDetail.push(addArr[item]);
        }
        this.$store.dispatch('setInputData', addArr);
        this.$store.dispatch('setInputData', {[this.data.key]: positionDetail.join('/').trim()});
        this.checkRuleValue=addArr;
      },
      getCar300Data:function () {
        var _this=this;
        var option={
          url:'/carInfo/info',
          method:'get',
          cache:true,
          beforeSend(){
            _this.$store.dispatch('showLoad',{[_this.data.key]:true});
          },
          success(){
            _this.$store.dispatch('showLoad',{[_this.data.key]:false});
          }
        };
        api.getCar300Data(option,function (data) {
          var domId = '#' + _this.data.key+'_input';
          if(_this.cityPicker){
            $(domId).citypicker('destroy')
          }
          var position=_this.position;
          var cityPicker = $(domId).citypicker({
            type:'car',
            disc:['车品牌','车系列','车型号'],
            placeholder: '请选择车品牌/车系列/车型号',
            province:position[_this.data.key+'_brand']||'',
            city:position[_this.data.key+'_series']||'',
            district:position[_this.data.key+'_model']||'',
            data:data,
            simple:true,
          }, function (data) {
            if (data) {
              _this.$nextTick(function () {
                var arr=data.split('/');
                var _province=arr[0]||'',
                  _city=arr[1]||'',
                  _counties=arr[2]||'';
                var newObj={};
                newObj[_this.data.key+'_brand']=_province;
                newObj[_this.data.key+'_series']=_city;
                newObj[_this.data.key+'_model']=_counties;
                _this.position=newObj
//                _this.checkRuleValue=newObj
              });
            }
          });
          if(_this.data.readonly){
            $(domId).citypicker('unbind')
          }
          _this.cityPicker = cityPicker;
          _this.addData=data;

        })
      }
    }
  }
</script>
