public class bowling
{
	public static Integer getBowlingScore(String input)
	{
		
		int throwList[] = new int [input.length()];
		for (int i=0; i<input.length(); i++)
		{
			if (input.charAt(i)=='X')
			{
				throwList[i]=10;
			}
			else if (input.charAt(i)=='/')
			{
				//we assume a valid sequence, hence no errorchecking
				//despite the seeming capacity for this to cause errors
				throwList[i]=10-throwList[i-1];			
			}
			else if (input.charAt(i)=='-')
			{
				
				throwList[i]=0;
				
			}
			else
			{
				throwList[i]=Integer.parseInt(input.substring(i,i+1));			
			}
			System.out.println(throwList[i]);
		}//end for i=0 to input.length
		System.out.println("---------");
		int frameList[] = new int [10];
		int throwCounter=0;
		int runningTotal=0;
		for (int i=0; i<frameList.length; i++)
		{
			if (input.charAt(throwCounter)=='X')
			{
				frameList[i]=10+throwList[throwCounter+1]+throwList[throwCounter+2];
				throwCounter++;
			}
			else if (input.charAt(throwCounter+1)=='/')
			{
				frameList[i]=10+throwList[throwCounter+2];
				throwCounter++;
				throwCounter++;
			}
			else
			{
				frameList[i]=throwList[throwCounter]+throwList[throwCounter+1];
				throwCounter++;
				throwCounter++;
			}
			System.out.println(frameList[i]);
			runningTotal=runningTotal+frameList[i];
		}//for i=0 to 10;
		
		return runningTotal;		
	} //end getBowlingScore
	public static void main(String [] args)
	{
		String inputString="5/8/9/7/8/6/9/7/6/45";
		System.out.println(inputString);
		System.out.println(getBowlingScore(inputString));
	}
}// end tenPin
