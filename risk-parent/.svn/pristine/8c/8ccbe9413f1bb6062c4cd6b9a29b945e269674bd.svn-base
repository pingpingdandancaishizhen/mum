<template>
<div class="float_menu" :style="{width:arrow=='left'?'120px':'23px'}" v-if="data&&data.length>1">
  <!--<div class="menu_arrow" @click="handleClick"><i :class="arrow=='left'?'fa fa-angle-double-right':'fa fa-angle-double-left'"></i></div>-->
  <div class="menu_content" :style="{display:arrow=='left'?'inline-block':'none'}">
    <div class="menu_li">
      <ul>
        <li @click="toTop">置顶</li>
        <a v-if="arrow=='left'" v-for="item in data" :href="'#a-'+item.key" :title="item.label" ><li  >{{item.label}}</li></a>
        <li @click="toBottom">置底</li>
      </ul>
    </div>
  </div>
  </ul>

</div>
</template>
<style>

</style>
<script>

    export default{
        data(){
            return{
              arrow:'left'
            }
        },
      props:['data'],
      methods:{
          handleClick:function () {
            if(this.arrow=='left'){
              this.arrow='right'
            }else{
              this.arrow='left'
            }

          },
        toTop:function () {
          $(document).scrollTop(0)
        },
        toBottom:function () {
          var $document=$(document);
          $document.scrollTop($document.height())
        },
      }
    }
</script>
