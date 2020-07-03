package testezinho.com;
import java.util.LinkedList;
public class Parentheses {
	
	public String reverse(String rev) {
		String r ="";
		String temp =rev;
		LinkedList<Character> list = new LinkedList<>();
		int t = temp.indexOf(')');
		while(t!=-1) {
			if(temp.substring(0, t).indexOf('(')==-1){//if an open parentheses doesn't exist in the current substring, enter
				int temp2 = temp.substring(t+1).indexOf(')');
				if (temp2!=-1) {//if there is a parentheses closing after the current substring, change the t variable to its index
					t += temp.substring(t+1).indexOf(')')+1;
				}else {//if not, just break the loop
					break;
				}
			}else {
				for(int j =t;j>=0;j--) {//go backwards from the position of the first closing parentheses
					if(temp.charAt(j)=='(') {//when '(' found, pop from the list
						while(list.size()>0) {
							r += list.pop();
						}
						temp = temp.substring(0, j) + r + temp.substring(t+1); //add the last working substring, to the new substring and to the next, if it has any, excluding the parentheses
						r = "";
						break;//break the for loop
					}else if (j!=t){
						list.add(temp.charAt(j));//add to the list
					}
				}
				t = temp.indexOf(')');//find the new ')' index, if it has any
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		Parentheses mano = new Parentheses();
		//System.out.println(mano.reverse("((bar)car)"));
		System.out.println(mano.reverse("(((bar(su))car)(viu)(sla))"));
	}

}
