package NodePackage;
import utils.*;
public class JumpStmtNode extends AbstractTreeNode{
	final JumpStmt statement;
	public JumpStmtNode(JumpStmt statement) {
		this.statement = statement;
	}
	@Override
	public JumpStmt execute(Context context) {
		return statement;
	}
}
