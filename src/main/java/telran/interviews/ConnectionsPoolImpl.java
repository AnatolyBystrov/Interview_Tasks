package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolImpl implements ConnectionsPool {
    int maxSize;

    LinkedHashMap<Integer, Connection> server = new LinkedHashMap<>(16, 0.75f, true) {

        @Override

        protected boolean removeEldestEntry(Map.Entry<Integer, Connection> oldEntry) {
            return size() > maxSize;
        }
    };

    public ConnectionsPoolImpl(int size) {
        this.maxSize = size;
    }

    public boolean addConnection(Connection connection) {
        boolean res = false;
        if (!server.containsKey(connection.getId())) {
            res = true;
            server.put(connection.getId(), connection);// âûáîð êëþ÷à
        }
        return res;
    }

    @Override
    public Connection getConnection(int id) {

        return server.get(id);
    }

}