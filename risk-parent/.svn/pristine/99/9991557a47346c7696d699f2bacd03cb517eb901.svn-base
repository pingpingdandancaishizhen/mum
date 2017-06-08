<template>
  <div>
    <div v-for="(item,index) in data">
      <app-text v-if="item.editor=='text'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd"  keep-alive/>

      <app-ID-account v-if="item.editor=='IDAccount'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-account v-if="item.editor=='account'&&item" :type="'account'" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-account v-if="item.editor=='amount'&&item" :type="'amount'" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-account v-if="item.editor=='mobile'&&item" :type="'mobile'" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-option v-if="item.editor=='option'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-option2 v-if="item.editor=='option2'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-radio v-if="item.editor=='radio'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-checkbox v-if="item.editor=='checkbox'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-single-checkbox v-if="item.editor=='single_checkbox'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-address v-if="item.editor=='address_pccd'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData"  :checkedAdd="checkedAdd"  keep-alive/>

      <app-car300 v-if="item.editor=='car300'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd"  keep-alive/>

      <app-date v-if="item.editor=='date'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-job v-if="item.editor=='job'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" :checkedAdd="checkedAdd" keep-alive/>

      <app-height-examine v-if="item.editor=='examine'&&item" :data="item" :oData="oData" :ruleData="rulesData" :attrsData="attrsData" :checkedAdd="checkedAdd" keep-alive/>

      <app-apply-examine v-if="item.editor=='applyExamine'&&item" :data="item" :oData="oData" :ruleData="rulesData" :attrsData="attrsData" :checkedAdd="checkedAdd" keep-alive/>

      <app-gen-button v-if="item.editor=='genbutton'&&item" :data="item" :oData="oData" :ruleData="rulesData" :attrsData="attrsData" :checkedAdd="checkedAdd" keep-alive/>

      <app-contract v-if="item.editor=='contract'&&item" :data="item" :oData="oData" :ruleData="rulesData" :attrsData="attrsData" keep-alive/>

      <app-p2p-loan-apply v-if="item.editor=='p2p_loan_apply'&&item" :oData="oData" :data="item" :ruleData="rulesData" :attrsData="attrsData" keep-alive/>

      <app-relation v-if="item.editor=='relation'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" keep-alive/>
      <app-credit v-if="item.editor=='credit'&&item" :data="item" :oData="oData" :attrsData="attrsData" :ruleData="rulesData" keep-alive/>
    </div>
  </div>
</template>
<script>
  import {mapGetters} from 'vuex';
  import comp from './index';
  export default{
    data(){
      return {
        currentView: {}
      }
    },
    props: ['data','checkedAdd'],
    computed: {
      ...mapGetters({
        'oData': 'optionData',
        'attrsData':'attrsData',
        'rulesData':'rulesData'
      }),
    },
    components: comp
  }
</script>
