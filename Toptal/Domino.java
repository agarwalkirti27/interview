/*
"Domino": We are given an S string, representing a domino tile chain. Each tile has an L-R format, where L and R are numbers from the 1..6 range. The tiles are separated by a comma. Some examples of a valid S chain are:

1. "6-3"
2. "4-3,5-1,2-2,1-3,4-4"
3. "1-1,3-5,5-2,2-3,2-4"

Devise a function that given an S string, returns the number of tiles in the longest matching group within S. A matching group is a set of tiles that match and that are subsequent in S.
Domino tiles match, if the right side of a tile is the same as the left side of the following tile. "2-4,4-1" are matching tiles, but "5-2,1-6" are not.

domino("6-3") // should return 1.
domino("4-3,5-1,2-2,1-3,4-4") // should return 1.
domino("1-1,3-5,5-2,2-3,2-4") // should return 3.

Test cases:

domino("1-1") // 1
domino("1-2,1-2") // 1
domino("3-2,2-1,1-4,4-4,5-4,4-2,2-1") // 4
domino("5-5,5-5,4-4,5-5,5-5,5-5,5-5,5-5,5-5,5-5") // 7
domino("1-1,3-5,5-5,5-4,4-2,1-3") // 4
domino("1-2,2-2,3-3,3-4,4-5,1-1,1-2") // 4/
*/

public class Domino {

    public static void main(String[] args) {

        String s = "1-1,3-5,5-2,2-3,2-4";
        String[] arr = s.split(",");

        int curr = 1;
        int len = 0;
        String lastR = "0";

        if (arr.length == 0) {
            System.out.println(0);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            String left = "";
            String right = "";
            String[] numArr = arr[i].split("-");
            if (numArr.length == 2) {
                left = numArr[0];
                right = numArr[1];
            }

            if (left.equals(lastR)) {
                curr++;
            } else if (curr > len) {
                len = curr;
                curr = 1;
            }
            lastR = right;

            if (curr > len) {
                len = curr;
            }

        }

        System.out.println(len);
    }
}
