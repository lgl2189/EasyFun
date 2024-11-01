import com.easyfun.entity.PhonePrefix;
import com.google.gson.Gson;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.*;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/24 上午10:29
 */


public class PhoneNumberTest {
    public static void main(String[] args) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        List<String> regionsCodes = new ArrayList<>();
        regionsCodes.add("CN");
        regionsCodes.add("HK");
        regionsCodes.add("MO");
        regionsCodes.add("TW");
        //HashSet加入重复值不会覆盖
        Set<String> supportedRegions = new HashSet<>(phoneNumberUtil.getSupportedRegions());
        supportedRegions.remove("CN");
        supportedRegions.remove("HK");
        supportedRegions.remove("MO");
        supportedRegions.remove("TW");
        regionsCodes.addAll(supportedRegions);
        ArrayList<PhonePrefix> phonePrefixes = new ArrayList<>();
        for(String regionCode : regionsCodes){
            Locale locale = new Locale("", regionCode);
            String regionName =null;
            if(regionCode.equals("TW")){
                regionName = "中国台湾";
            }
            else{
                regionName = locale.getDisplayCountry();
            }
            String regionPhoneCode = String.valueOf(phoneNumberUtil.getCountryCodeForRegion(regionCode));
            PhonePrefix phonePrefix = new PhonePrefix(regionPhoneCode, regionName);
            phonePrefixes.add(phonePrefix);
        }
        System.out.println(new Gson().toJson(phonePrefixes));
    }
}