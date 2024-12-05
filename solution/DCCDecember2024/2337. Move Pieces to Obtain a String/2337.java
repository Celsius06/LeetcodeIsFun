// 2337. Move Pieces to Obtain a String

// Two-Pointer
// 36ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canChange(String start, String target) {
        List<Position> startPositions = getPositions(start);
        List<Position> targetPositions = getPositions(target);
        
        if (startPositions.size() != targetPositions.size()) {
            return false;
        }
        
        for (int i = 0; i < startPositions.size(); i++) {
            Position startPos = startPositions.get(i);
            Position targetPos = targetPositions.get(i);
            
            if (startPos.type != targetPos.type || 
                (startPos.type == 'L' && startPos.index < targetPos.index) || 
                (startPos.type == 'R' && startPos.index > targetPos.index)) {
                return false;
            }
        }
        
        return true;
    }

    private List<Position> getPositions(String s) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L' || ch == 'R') {
                positions.add(new Position(ch, i));
            }
        }
        return positions;
    }

    private static class Position {
        char type; // 'L' or 'R'
        int index;

        Position(char type, int index) {
            this.type = type;
            this.index = index;
        }
    }
}