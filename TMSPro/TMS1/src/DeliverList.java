
public class DeliverList {
	private int id;
	private int projectId;
	private int taskId;
	private String title;
	private String deliverNo;
	private String developer;
	private String tester;
	private String applicationName;
	private String content;
	private String comments;
	private String createUser;
	private String updateUser;

////测试用
//	public DeliverList(int projectId, int taskId, String title, String deliverNo, String developer, String tester,
//			String applicationName, String content, String comments, String createUser, String updateUser) {
//		super();
//		this.projectId = projectId;
//		this.taskId = taskId;
//		this.title = title;
//		this.deliverNo = deliverNo;
//		this.developer = developer;
//		this.tester = tester;
//		this.applicationName = applicationName;
//		this.content = content;
//		this.comments = comments;
//		this.createUser = createUser;
//		this.updateUser = updateUser;
//	}
//	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeliverNo() {
		return deliverNo;
	}
	public void setDeliverNo(String deliverNo) {
		this.deliverNo = deliverNo;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
