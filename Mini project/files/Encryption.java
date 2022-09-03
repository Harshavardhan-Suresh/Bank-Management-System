class Encryption
{
    String encrypt(String data,String key)  //decrypting using simple algorithm based on person's account number
    {
        int acnolen=key.length();
        char tmp1,tmp2,tmp3;
        String newdata="";
        for(int i=0;i<data.length();i++)
        {
            if(i%2==0)
            {
                tmp1=data.charAt(i);
                tmp2=key.charAt(i%acnolen);
                tmp3=(char)(((int)tmp1+(int)tmp2)%128);
                newdata+=tmp3;
                //System.out.println((int)tmp1+" "+(int)tmp2+" "+(int)tmp3);
            }
            else
            {
                tmp1=data.charAt(i);
                tmp2=key.charAt(i%acnolen);
                int tmpval=((int)tmp1-(int)tmp2)%128;
                if(tmpval<0&&tmpval>-128)
                    tmpval=128+tmpval;
                else if(tmpval<-128)
                    System.out.println("ERROR: "+tmpval+" for data "+data.charAt(i));
                newdata+=(char)tmpval;
                //System.out.println((int)tmp1+" "+(int)tmp2+" "+(int)tmpval);
            }
        }
        return newdata;
    }
    String decrypt(String data,String key)  //decrypting using simple algorithm based on person's account number
    {
        int acnolen=key.length();
        char tmp1,tmp2,tmp3;
        String newdata="";
        for(int i=0;i<data.length();i++)
        {
            if(i%2==1)
            {
                tmp1=data.charAt(i);
                tmp2=key.charAt(i%acnolen);
                tmp3=(char)(((int)tmp1+(int)tmp2)%128);
                newdata+=tmp3;
                //System.out.println((int)tmp1+" "+(int)tmp2+" "+(int)tmp3);
            }
            else
            {
                tmp1=data.charAt(i);
                tmp2=key.charAt(i%acnolen);
                int tmpval=((int)tmp1-(int)tmp2)%128;
                if(tmpval<0&&tmpval>-128)
                    tmpval=128+tmpval;
                else if(tmpval<-128)
                    System.out.println("ERROR: "+tmpval+" for data "+data.charAt(i));
                newdata+=(char)tmpval;
                //System.out.println((int)tmp1+" "+(int)tmp2+" "+(int)tmpval);
            }
        }
        return newdata;
    }
}