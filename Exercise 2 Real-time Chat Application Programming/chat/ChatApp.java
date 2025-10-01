package chat;
import java.util.*;

interface CommunicationProtocol {
    void send(String user, String message);
}

class WebSocketProtocol implements CommunicationProtocol {
    public void send(String user, String message) {
        System.out.println("[" + user + "]: " + message);
    }
}

interface Observer {
    void update(String user, String message);
}

class User implements Observer {
    private String name;
    private CommunicationProtocol protocol;

    public User(String name, CommunicationProtocol protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    public String getName() { return name; }

    @Override
    public void update(String user, String message) {
        protocol.send(user, message);
    }
}


class ChatRoom {
    private String id;
    private List<User> users = new ArrayList<>();

    public ChatRoom(String id) { this.id = id; }

    public void join(User user) { users.add(user); }

    public void broadcast(String fromUser, String message) {
        for (User u : users) {
            if (u.getName().equals(fromUser)) {
                u.update(fromUser, message);
            }
        }
    }

    public List<String> getActiveUsers() {
        List<String> names = new ArrayList<>();
        for (User u : users) names.add(u.getName());
        return names;
    }
}

class ChatRoomManager {
    private static ChatRoomManager instance = new ChatRoomManager();
    private Map<String, ChatRoom> rooms = new HashMap<>();
    private ChatRoomManager() {}
    public static ChatRoomManager getInstance() { return instance; }
    public ChatRoom getOrCreateRoom(String id) {
        return rooms.computeIfAbsent(id, ChatRoom::new);
    }
}

public class ChatApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatRoomManager manager = ChatRoomManager.getInstance();

        // Get ChatRoom ID
        System.out.print("Enter Chat Room ID: ");
        String roomId = sc.nextLine();
        ChatRoom room = manager.getOrCreateRoom(roomId);
        System.out.print("Enter number of users: ");
        int n = Integer.parseInt(sc.nextLine());

        List<User> userList = new ArrayList<>();
        List<String> usernames = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter username for User " + i + ": ");
            String name = sc.nextLine();
            usernames.add(name);
            User u = new User(name, new WebSocketProtocol());
            userList.add(u);
            room.join(u);
        }


        List<String> messages = new ArrayList<>();
        System.out.println("Enter " + n + " messages (one for each user in order):");
        for (int i = 0; i < n; i++) {
            System.out.print("Message for " + usernames.get(i) + ": ");
            messages.add(sc.nextLine());
        }


        System.out.println("\nPossible Inputs:");
        System.out.println("Chat Room ID: \"" + roomId + "\"");
        System.out.println("Messages: " + messages);
        System.out.println("Active Users: " + usernames);

        System.out.println("\nPossible Outputs:");
        for (int i = 0; i < n; i++) {
            room.broadcast(usernames.get(i), messages.get(i));
        }
        System.out.println("Active Users: " + usernames);

        sc.close();
    }
}
