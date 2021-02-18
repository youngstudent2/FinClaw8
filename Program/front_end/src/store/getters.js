const getters = {
  //user
  token: state => state.user.token,
  userId: state => state.user.userId,
  userInfo: state => state.user.userInfo,
  AllUsers: state => state.user.AllUsers,
  unauthorizedUsers: state => state.user.unauthorizedUsers,
  accountModalVisible: state => state.user.accountModalVisible,
  temp: state => state.user.temp,

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

  // attendance
  attendedProjects: state => state.cooperation.attendedProjects,
  unattendedProjects: state => state.cooperation.unattendedProjects,
  // dataManager
  AllDataManagers: state => state.user.AllDataManagers,
  DataManagerRegistrationModalVisible: state => state.user.DataManagerRegistrationModalVisible,
  // lender
  lendingHistory: state => state.lender.lendingHistory,
  allLoanApplication: state => state.lender.allLoanApplication,
  addLendingWishModalVisible: state => state.lender.addLendingWishModalVisible,
  currentLoanerInfo: state => state.lender.currentLoanerInfo,
  // authority
  cooperationList: state => state.authority.cooperationList,
  controlModalVisible: state => state.authority.controlModalVisible,
  currentServerInfo: state => state.authority.currentServerInfo,
  currentAttendanceInfo: state => state.authority.currentAttendanceInfo,
  // project
  projectID: state => state.project.currentProjectID,
  projectInfo: state => state.project.currentProjectInfo,
  projectList: state => state.project.projectList,
  addProjectModalVisible: state => state.project.addProjectModalVisible,
  //predict
  predictScore: state => state.predict.predictScore,
  // loan
  userLoanHistory: state => state.loaner.userLoanHistory,
}
  
export default getters