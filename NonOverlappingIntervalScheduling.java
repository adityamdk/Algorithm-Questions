//Given a set of jobs with start and end time, write a function to return maximum number of jobs that can be scheduled

package nonoverlappingintervalscheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Job
{
    int startTime;
    int endTime;
    Job(int s,int e)
    {
        startTime =s;
        endTime = e;
    }
}

public class NonOverlappingIntervalScheduling {
    
    private ArrayList<Job> ScheduleTasks(ArrayList<Job> myJob)
    {
       ArrayList<Job> FinalOutput = new ArrayList<>();
        Collections.sort(myJob, new Comparator<Job>()  
        {  
            public int compare(Job t1,Job t2)
            {
                return t1.endTime-t2.endTime; 
            }   
        }
        );
         Iterator it = myJob.iterator();
         Job firstObj = (Job)it.next();
         Job secondObj;
         FinalOutput.add(firstObj);
         while(it.hasNext())
         {
             secondObj = (Job)it.next();
             if(secondObj.startTime >=firstObj.endTime)
             {
                 FinalOutput.add(secondObj);
             }
         }
        return FinalOutput;
    }
    public static void main(String[] args) 
    {
          Job j1 = new Job(3,4);
          Job j2 = new Job(2,3);
          Job j3 = new Job(9,10);
          Job j4 = new Job(10,11);
          Job j5 = new Job(2,4);
          ArrayList<Job> list = new ArrayList<>();
          list.add(j1);
          list.add(j2);
          list.add(j3);
          list.add(j4);
          list.add(j5);

          Iterator it = list.iterator();
          System.out.println("Input jobs are: ");
          while(it.hasNext())
          {
             Job temp = (Job)it.next();
             System.out.println("Start Time: "+temp.startTime+" End time "+temp.endTime);
          }
          
          
          NonOverlappingIntervalScheduling obj = new NonOverlappingIntervalScheduling();
          ArrayList<Job> output= obj.ScheduleTasks(list);
          Iterator its = output.iterator();
          System.out.println("#######################################################################################################");
          System.out.println("Scheduled jobs are: ");
          while(its.hasNext())
          {
             Job temp = (Job)its.next();
             System.out.println("Start Time: "+temp.startTime+" End time "+temp.endTime);
          }
           System.out.println("#######################################################################################################");
         
    }
}
