<template>
  <div>
    <a-popconfirm
      title="确认退出这个项目吗"
      ok-text="确认"
      cancel-text="取消"
      @confirm="quit"
    >
      <a-button type="danger">退出项目</a-button>
    </a-popconfirm>
  </div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
  data() {
    return {};
  },
  computed : {
    ...mapGetters([
      'userInfo'
    ])
  },
  methods: {
    ...mapActions(["quitProject"]),
    async quit() {
      const projectID = this.$route.params.projectID;
      await this.quitProject({projectID:projectID,cooperationID:this.userInfo.cooperationID})
      this.$router.replace({
        name:'cooperatorHome',
      })
    },
  },
};
</script>

<style>
</style>