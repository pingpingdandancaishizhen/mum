<template>
  <div>
    <div class="row-right" :class="!checkedAdd?'col-sm-6':'col-sm-6 checkedAdd'">
      <div class="form-group input-group " :id="data.key">
        <label class="label-head label-head-lg label-head-top  text-right"  v-if="!checkedAdd"><span :class="data.required?'require':''">{{data.label}}:</span></label>
        <div class="label-box label-box-sm">
          <input type="text" class="form-control" :name="data.key"  placeholder="" v-model="formatValue" @input="handleInput" @blur="handleBlur"  :disabled="data.readonly?true:false">
        </div>
        <div class="form-error-tip">{{errorMsg[data.key]}}</div>
      </div>
    </div>
    <div class="row-right col-sm-6">
      <div class="form-group input-group ">
        <label class="label-head label-head-lg label-head-top  text-right" ><span >性别:</span></label>
        <div class="label-box label-box-sm">
          <input type="text" class="form-control" disabled="disabled" v-model="gender">
          <div class="form-error-tip"></div>
        </div>
      </div>
    </div>
    <div class="row-right col-sm-6">
      <div class="form-group input-group ">
        <label class="label-head label-head-lg label-head-top  text-right" ><span >生日:</span></label>
        <div class="label-box label-box-sm">
          <input type="text" class="form-control" disabled="disabled" v-model="birthday">
          <div class="form-error-tip"></div>
        </div>
      </div>
    </div>
    <div class="row-right col-sm-6">
      <div class="form-group input-group ">
        <label class="label-head label-head-lg label-head-top  text-right" ><span >年龄:</span></label>
        <div class="label-box label-box-sm">
          <input type="text" class="form-control" disabled="disabled" v-model="age">
          <div class="form-error-tip"></div>
        </div>
      </div>
    </div>
  </div>

</template>
<script>
  import checkRule from '../mixins/checkRule'
  export default{
    mixins:[checkRule],
    data(){
      return {
        value:'',
        formatValue:'',
        gender:'',
        birthday:'',
        age:''
      }
    },
    props: ['data','oData','attrsData','checkedAdd'],
    created:function () {
      var attrValue=this.attrsData[this.data.key]||{};
      var value=attrValue ? (attrValue.draftValue==null?(attrValue.attrValue||''):attrValue.draftValue) : '';
      var attrValue_birthday=this.attrsData[this.data.key+'_birthday']||{};
      var value_birthday=attrValue_birthday ? (attrValue_birthday.draftValue==null?(attrValue_birthday.attrValue||''):attrValue_birthday.draftValue) : '';
      var attrValue_gender=this.attrsData[this.data.key+'_gender']||{};
      var value_gender=attrValue_gender ? (attrValue_gender.draftValue==null?(attrValue_gender.attrValue||''):attrValue_gender.draftValue) : '';
      var attrValue_age=this.attrsData[this.data.key+'_age']||{};
      var value_age=attrValue_age ? (attrValue_age.draftValue==null?(attrValue_age.attrValue||''):attrValue_age.draftValue) : '';

      this.value=value;
      this.formatValue=this.formatAccount(value,'IDAccount');
      var inputData= {
        [this.data.key]: value,
        [this.data.key + '_birthday']: value_birthday,
        [this.data.key + '_gender']: value_gender,
        [this.data.key + '_age']: value_age,
      }
      this.$store.dispatch('setInputData', inputData);
      var birthDay=this.getBirthDay(value);
      var gender=this.getgender(value);
      this.birthday=birthDay;
      this.gender=gender;
      this.age=this.getAge(value);
      this.$watch('value',this.handleWatch)
    },
    methods:{
      handleInput(e){
        var value=e.target.value;
        this.value=this.unFormatAccount(value);
        this.formatValue=this.formatAccount(value,'IDAccount')
      },
      handleBlur() {
        this.formatValue=this.formatAccount(this.value,'IDAccount')
      },
      handleWatch(val){
        var valData={};
        valData[this.data.key]=val;
        this.checkRuleValue=Object.assign({},this.checkRuleValue,valData);
        var birthDay=this.getBirthDay(val);
        var gender=this.getgender(val);
        var age=this.getAge(val);
        this.birthday=birthDay;
        this.gender=gender;
        this.age=age;
        var inputData= {
          [this.data.key]: val,
          [this.data.key + '_birthday']: birthDay,
          [this.data.key + '_gender']: gender,
          [this.data.key + '_age']: age,
        }
        this.$store.dispatch('setInputData', inputData);
      },
      getBirthDay:function (IDNO) {
        var birthdayno='',birthdaytemp='';
        if(IDNO.length==18){
          birthdayno=IDNO.substring(6,14)
        }
        if(IDNO.length==15){
          birthdaytemp=IDNO.substring(6,12)
          birthdayno="19"+birthdaytemp
        }
        var birthday=birthdayno&&(birthdayno.substring(0,4)+"-"+birthdayno.substring(4,6)+"-"+birthdayno.substring(6,8))
        return birthday
      },
      getgender:function (IDNO) {
        var genderno='',gender=''
        if(IDNO.length==18){
          genderno=IDNO.substring(16,17)
        }
        if(IDNO.length==15){
          genderno=IDNO.substring(14,15)
        }
        var tempid=genderno%2;
        if(genderno!=''){
          if(tempid==0){
            gender='女'
          }else{
            gender='男'
          }
        }

        return gender
      },
      getAge(IDNO){
        var now=new Date();
        var nowYear=now.getFullYear();
        var birthDay=this.birthday;
        var age='';
        if(birthDay){
          var oldYear=birthDay.split('-')[0];
          age=nowYear-oldYear;
        }
        return age;
      }
    }
  }
</script>
