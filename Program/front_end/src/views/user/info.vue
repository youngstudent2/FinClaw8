<template>
  <a-layout>
    <Header></Header>

    <a-layout-content style="align: center">
      <div id="info">
        <a-form :form="form" style="margin-top: 30px">
          <a-form-item
            label="用户名"
            :label-col="{ span: 3 }"
            :wrapper-col="{ span: 8, offset: 1 }"
          >
            <a-input
              placeholder="请填写用户名"
              v-decorator="[
                'userName',
                { rules: [{ required: true, message: '请输入用户名' }] },
              ]"
              v-if="modify"
            />
            <span v-else>{{ userInfo.username }}</span>
          </a-form-item>
          <a-form-item
            label="邮箱"
            :label-col="{ span: 3 }"
            :wrapper-col="{ span: 8, offset: 1 }"
          >
            <span>{{ userInfo.email }}</span>
          </a-form-item>
          <a-form-item
            label="角色"
            :label-col="{ span: 3 }"
            :wrapper-col="{ span: 8, offset: 1 }"
          >
            <span>{{ userInfo.role }}</span>
          </a-form-item>
          <a-form-item :wrapper-col="{ span: 12, offset: 5 }" v-if="modify">
            <a-button type="primary" @click="saveModify"> 保存 </a-button>
            <a-button
              type="default"
              style="margin-left: 30px"
              @click="cancelModify"
            >
              取消
            </a-button>
          </a-form-item>
          <a-form-item :wrapper-col="{ span: 8, offset: 4 }" v-else>
            <a-button type="primary" @click="modifyInfo" style="margin-right:10px"> 修改信息 </a-button>
            <a-upload
              :file-list="fileList"
              :multiple="false"
              :remove="handleRemove"
              :before-upload="beforeUpload"
            >
              <a-button> 选择文件 </a-button>
            </a-upload>
            <a-button
            :disabled="fileList.length === 0"
            :loading="uploadState"
            style="margin-top: 10px"
            @click="handleUpload"
        >
            <a-icon type="upload" /> {{ uploadState ? '正在上传' : '上传文件' }}
        </a-button>
          </a-form-item>
        </a-form>
      </div>
    </a-layout-content>
  </a-layout>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from "vuex";
import Header from "@/components/header";
export default {
  name: "info",
  data() {
    return {
      modify: false,
      formLayout: "horizontal",
      pagination: {},
      data: [],
      fileList: [],
      form: this.$form.createForm(this, { name: "coordinated" }),
    };
  },
  components: {
    Header,
  },
  computed: {
    ...mapGetters(["userId", "userInfo","uploadState"]),
  },
  async mounted() {
    await this.getUserInfo();
    console.log(this.userInfo);
  },
  methods: {
    ...mapActions(["getUserInfo", "updateUserInfo","uploadFile"]),
    handleRemove(file) {
      const index = this.fileList.indexOf(file);
      const newFileList = this.fileList.slice();
      newFileList.splice(index, 1);
      this.fileList = newFileList;
    },
    beforeUpload(file) {
      this.fileList = [...this.fileList, file];
      return false;
    },
    handleUpload(e) {
            let formData = new FormData()
            formData.append('multipartFile', this.fileList[0])
            //formData.append('projectID', Number(this.projectID))
            formData.append('operatorID', Number(this.userId))
            this.uploadFile(formData)
        },
    saveModify() {
      this.form.validateFields((err, values) => {
        if (!err) {
          const data = {
            userName: this.form.getFieldValue("userName"),
            phoneNumber: this.form.getFieldValue("phoneNumber"),
            password: this.form.getFieldValue("password"),
          };
          this.updateUserInfo(data).then(() => {
            this.modify = false;
          });
        }
      });
    },
    modifyInfo() {
      setTimeout(() => {
        this.form.setFieldsValue({
          userName: this.userInfo.userName,
          phoneNumber: this.userInfo.phoneNumber,
        });
      }, 0);
      this.modify = true;
    },
    cancelModify() {
      this.modify = false;
    },
  },
};
</script>

<style scoped lang="less">
.info-wrapper {
  padding: 50px;
  .chart {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 20px;
  }
}
</style>
<style lang="less">
.info-wrapper {
  .ant-tabs-bar {
    padding-left: 30px;
  }
}
</style>
<style lang="less">
</style>