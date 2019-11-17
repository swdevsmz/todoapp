package todoapp.dao.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import todoapp.model.todo.Todo;

public class TodoDAO {
	private Connection db;        // todoappデータベースに接続されたコネクション
	private PreparedStatement ps; // sql文を保持する変数
	private ResultSet rs;         // 結果セット(SQL文を実行した結果の集合)を保持

	//接続処理
	private void connect() throws NamingException, SQLException {
	    InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/tododb");
		db = ds.getConnection();
	}

	//切断処理
	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Todo> findAll(){
		List<Todo> list=new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT id, title, importance FROM todos ORDER BY importance DESC");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int importance = rs.getInt("importance");
				list.add(new Todo(id, title, importance));
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}

	public void insert(Todo todo) {
		try {
			this.connect();
			ps = db.prepareStatement("INSERT INTO todos(title, importance) VALUES(?,?)");
			ps.setString(1, todo.getTitle());
			ps.setInt(2, todo.getImportance());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public Todo findById(int id) {
		Todo todo = null;
		try {
			this.connect();
			ps = db.prepareStatement("SELECT title, importance FROM todos WHERE id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				int importance = rs.getInt("importance");
				todo = new Todo(id, title, importance);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return todo;
	}

	public void update(Todo todo) {
		try {
			this.connect();
			ps = db.prepareStatement("UPDATE todos SET title = ?,importance = ? WHERE id = ?");
			ps.setString(1, todo.getTitle());
			ps.setInt(2, todo.getImportance());
			ps.setInt(3, todo.getId());
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public void delete(int id) {
		try {
			this.connect();
			ps = db.prepareStatement("DELETE FROM todos WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}
