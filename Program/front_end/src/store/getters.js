const getters = {
  //user
  token: state => state.user.token,
  userId: state => state.user.userId,
  userInfo: state => state.user.userInfo,

  // file
  uploadState: state => state.file.uploadState,
  downloadState: state => state.file.downloadState,
  uploadedFileList: state => state.file.uploadedFileList,
  metadataVisible: state => state.file.metadataVisible,
  metadata: state => state.file.metadata,
  // model
  modelList: state => state.model.modelList,
  // monitor
  monitorInfo: state => state.monitor.monitorInfo,
  // data
  projectData: state => state.data.projectData,

  // cooperation
  attendedProjects: state => state.cooperation.attendedProjects,
  unattendedProjects: state => state.cooperation.unattendedProjects,
  // dataManager
  AllDataManagers: state => state.user.AllDataManagers,
  DataManagerRegistrationModalVisible: state => state.user.DataManagerRegistrationModalVisible,
  // authority
  cooperationsList: state => state.authority.cooperationsList,
  // project
  projectID: state => state.project.currentProjectID,
  projectInfo: state => state.project.currentProjectInfo,
  projectList: state => state.project.projectList,
  addProjectModalVisible: state => state.project.addProjectModalVisible,
  //predict
  predictScore: state => state.predict.predictScore,
}
  
export default getters