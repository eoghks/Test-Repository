package BinarySearch;

public class ListVersion {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 6 , 8, 9, 11, 15};
		Node root = makdeTestNode(arr, 0, arr.length -1);
		String result = binarySearch(root, 9);
		System.out.println(result);
	}

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	public static Node makdeTestNode(int arr[], int start, int end) {
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);

		if(mid - 1 >= start) {
			Node left = makdeTestNode(arr, start, mid-1);
			node.left = left;
		}

		if(mid + 1 <= end) {
			Node right = makdeTestNode(arr, mid + 1 , end);
			node.right = right;
		}

		return node;
	}

	public static String binarySearch(Node node, int target) {
		StringBuilder sb = new StringBuilder();
		sb.append("root");
		while(node != null) {
			if(node.val == target) {
				sb.append("에 존재합니다.");
				return sb.toString();
			} else if (node.val > target) {
				sb.append(" -> left");
				node = node.left;
			} else if (node.val < target) {
				sb.append(" -> right");
				node = node.right;
			}
		}

		sb.append(target+"이 존재하지 않습니다.");
		return sb.toString();
	}
}
