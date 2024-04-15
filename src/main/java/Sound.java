import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {  
    int temp = 0; 
    for(int i = 0; i < samples.length; i++){
      if(samples[i] < limit*-1){
        samples[i] = limit * -1;
        temp++;
      }
      else if(samples[i] > limit){
        samples[i] = limit;
        temp++;
      }
    }
    return temp;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning()
  {
    int hold = 0;
    for(int i = 0; i < samples.length; i++){
      if(samples[i] != 0){
        hold = i;
        break;
      }
    }
    int [] tempList = new int[samples.length - hold];
    int count = 0;
    for(int i = hold; i < samples.length; i++){
      tempList[count] = samples[i];
      count++;
    }
    samples = tempList;
}
}
