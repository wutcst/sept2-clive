package cn.edu.whut.sept.zuul;
@RestController
@RequestMapping("/game")
public class GameController {

        private Map<String, Room> rooms;
        private Player player;

        // Constructor, getters, and setters

        @GetMapping("/start")
        public String startGame(@RequestParam String playerName) {
            // Initialize game, set up rooms, player, etc.
            return "Welcome, " + playerName + "!";
        }

        @GetMapping("/look")
        public Room getCurrentRoom() {
            return player.getCurrentRoom();
        }

        @PostMapping("/move")
        public ResponseEntity<String> movePlayer(@RequestParam String direction) {
            // Move player to the specified direction
            return ResponseEntity.ok("Player moved successfully.");
        }

        @PostMapping("/take")
        public ResponseEntity<String> takeItem(@RequestParam String itemName) {
            // Take the specified item from the current room
            return ResponseEntity.ok("Item taken successfully.");
        }

        @PostMapping("/drop")
        public ResponseEntity<String> dropItem(@RequestParam String itemName) {
            // Drop the specified item from the player's inventory
            return ResponseEntity.ok("Item dropped successfully.");
        }

        @GetMapping("/items")
        public ResponseEntity<List<Item>> getItems() {
            // Get items in the current room and player's inventory
            return ResponseEntity.ok(items);
        }

        @PostMapping("/eat-cookie")
        public ResponseEntity<String> eatCookie() {
            // Check if player has a magic cookie and increase max weight
            return ResponseEntity.ok("Cookie eaten successfully.");
        }
}
