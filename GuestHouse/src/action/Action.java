package action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pageMoveAction.PageMoveAction;

public interface Action {
	public abstract PageMoveAction execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException;

}
