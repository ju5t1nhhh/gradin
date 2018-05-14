<template>
  <div style="background-color:ghostwhite;height:100%;">
      <headTop></headTop>
      <div style="background-color:white;position:absolute;top:150px;width:55%;border: 1px solid #dbdbdb;left:22.5%;">
        <el-select v-model="value" placeholder="请选择版区" style="margin:20px 0 20px 20px">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <textarea style="resize:none;width:80%;margin: 20px 0 20px 20px;border-bottom: 1px solid #dbdbdb;border-right: 1px solid #dbdbdb;" placeholder="大胆发表你的作品吧.." rows="4"></textarea>
        <el-upload style="margin: 0 0 0 20px;"
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove">
              <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>{{dialogImageUrl}}
        <el-button style="margin:20px 0 20px 20px">发表</el-button>
      </div>
      
  </div>
</template>

<script>
import headTop from "../components/headTop";
export default {
  components: {
      headTop,
  },
  data() {
      return {
        dialogImageUrl: '',
        dialogVisible: false,
        options: [{
          value: '选项1',
          label: '摄影版区'
        }, {
          value: '选项2',
          label: '体育版区'
        }, {
          value: '选项3',
          label: '生活版区'
        }],
      };
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      }
    }
}
</script>
