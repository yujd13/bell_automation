package ca.elecsoft.dynamics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Prop {
    File outputFilePath;
    Properties prop;

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getDEFAULT_WAIT_TIME() {
        return DEFAULT_WAIT_TIME;
    }

    public String getENVIRONMENT_URL() {
        return ENVIRONMENT_URL;
    }

    public String getWEB_DRIVER_PATH() {
        return WEB_DRIVER_PATH;
    }

    public final String USER_NAME = "USER_NAME";
    public final String PASSWORD = "PASSWORD";
    public final String DEFAULT_WAIT_TIME = "DEFAULT_WAIT_TIME";
    public final String ENVIRONMENT_URL = "ENVIRONMENT_URL";
    public final String WEB_DRIVER_PATH = "WEB_DRIVER_PATH";
    public final String BROWSER = "BROWSER";
    public final String DEFAULT_WAIT_ATTEMPTS = "DEFAULT_WAIT_ATTEMPTS";
    public final String LEAD_LIST_VIEW_PAGE_URL = "LEAD_LIST_VIEW_PAGE_URL";
    public final String NEW_LEAD_PAGE_URL = "NEW_LEAD_PAGE_URL";
    public final String APP_PAGE_URL = "APP_PAGE_URL";
    public final String TECH_PORTAL_URL = "TECH_PORTAL_URL";
    public final String TECH_PORTAL_USER_NAME = "TECH_PORTAL_USER_NAME";
    public final String TECH_PORTAL_PASSWORD = "TECH_PORTAL_PASSWORD";
    public final String DART_URL = "DART_URL";
    public final String DART_USER_NAME = "DART_USER_NAME";
    public final String DART_PASSWORD = "DART_PASSWORD";
    public final String TECH_ID = "TECH_ID";
    public final String DART_ORDER = "DART_ORDER";
    public final String AUTH_URL = "AUTH_URL";
    public final String SBN_USER_NAME = "SBN_USER_NAME";
    public final String SBN_PASSWORD = "SBN_PASSWORD";
    public final String GET_WORK_ORDER_SBN_URL = "GET_WORK_ORDER_SBN_URL";
    public final String G_TA_BASIC_URL = "G_TA_BASIC_URL";
    public final String G_BILLING_ACCOUNTS_URL = "G_BILLING_ACCOUNTS_URL";
    public final String G_BILLING_PAYMEANS_URL = "G_BILLING_PAYMEANS_URL";
    public final String DEFAULT_THREAD_SLEEP = "DEFAULT_THREAD_SLEEP";
    public final String DATA_SEED_FILE = "DATA_SEED_FILE";
    public final String WORKORDER_LISTVIEW = "WORKORDER_LISTVIEW";
    public final String ROOT_URL = "ROOT_URL";
    public final String REPAIR_FLOW = "REPAIR_FLOW";
    public final String PROCESS_LINK_FILES = "PROCESS_LINK_FILES";
    public final String WORKORDER_HTML = "WORKORDER_HTML";
    public final String CASETYPE_FILE = "CASETYPE_FILE";
    public final String GENERAL_PROCESS_FILE = "GENERAL_PROCESS_FILE";
    public final String CASE_ACCOUNTS_FILE = "CASE_ACCOUNTS_FILE";
    public final String CASE_ACTUAL_FILE = "CASE_ACTUAL_FILE";
    public final String CASE_SCHEDULE_FILE = "CASE_SCHEDULE_FILE";
    public final String ENTITIES_MAP_API_FILE = "ENTITIES_MAP_API_FILE";
    public final String G_MA_INSTALLED_COMPONENTS = "G_MA_INSTALLED_COMPONENTS";
    public final String G_CYCLE_FEE="G_CYCLE_FEE";
    public final String CONTRACT_FILE="CONTRACT_FILE";

    public String getCONTRACT_FILE() {
        return CONTRACT_FILE;
    }

    public String getG_CYCLE_FEE() {
        return G_CYCLE_FEE;
    }

    public String getG_MA_INSTALLED_COMPONENTS() {
        return G_MA_INSTALLED_COMPONENTS;
    }

    public String getENTITIES_MAP_API_FILE() {
        return ENTITIES_MAP_API_FILE;
    }

    public String getCASE_SCHEDULE_FILE() {
        return CASE_SCHEDULE_FILE;
    }

    public String getCASE_ACTUAL_FILE() {
        return CASE_ACTUAL_FILE;
    }

    public String getCASE_ACCOUNTS_FILE() {
        return CASE_ACCOUNTS_FILE;
    }

    public String getGENERAL_PROCESS_FILE() {
        return GENERAL_PROCESS_FILE;
    }

    public String getCASETYPE_FILE() {
        return CASETYPE_FILE;
    }

    public String getWORKORDER_HTML() {
        return WORKORDER_HTML;
    }

    public String getPROCESS_LINK_FILES() {
        return PROCESS_LINK_FILES;
    }

    public String getPROCESS_FILE() {
        return PROCESS_FILE;
    }

    public final String PROCESS_FILE = "PROCESS_FILE";

    public String getREPAIR_FLOW() {
        return REPAIR_FLOW;
    }

    public String getROOT_URL() {
        return ROOT_URL;
    }

    public String getWORKORDER_LISTVIEW() {
        return WORKORDER_LISTVIEW;
    }

    public String getDATA_SEED_FILE() {
        return DATA_SEED_FILE;
    }

    public String getDEFAULT_THREAD_SLEEP() {
        return DEFAULT_THREAD_SLEEP;
    }

    public String getG_CONTRACT_BASICS_URL() {
        return G_CONTRACT_BASICS_URL;
    }

    public final String G_CONTRACT_BASICS_URL = "G_CONTRACT_BASICS_URL";

    public String getG_BILLING_PAYMEANS_URL() {
        return G_BILLING_PAYMEANS_URL;
    }

    public String getG_BILLING_ACCOUNTS_URL() {
        return G_BILLING_ACCOUNTS_URL;
    }

    public String getG_TA_BASIC_URL() {
        return G_TA_BASIC_URL;
    }

    public String getGET_WORK_ORDER_SBN_URL() {
        return GET_WORK_ORDER_SBN_URL;
    }

    public String getSBN_USER_NAME() {
        return SBN_USER_NAME;
    }

    public String getSBN_PASSWORD() {
        return SBN_PASSWORD;
    }

    public String getAUTH_URL() {
        return AUTH_URL;
    }

    public String getDART_ORDER() {
        return DART_ORDER;
    }

    public String getDART_USER_NAME() {
        return DART_USER_NAME;
    }

    public String getDART_PASSWORD() {
        return DART_PASSWORD;
    }

    public String getTECH_ID() {
        return TECH_ID;
    }

    public String getBROWSER() {
        return BROWSER;
    }

    public String getTECH_PORTAL_USER_NAME() {
        return TECH_PORTAL_USER_NAME;
    }

    public String getTECH_PORTAL_PASSWORD() {
        return TECH_PORTAL_PASSWORD;
    }

    public String getDART_URL() {
        return DART_URL;
    }

    public String getTECH_PORTAL_URL() {
        return TECH_PORTAL_URL;
    }


    public String getLEAD_LIST_VIEW_PAGE_URL() {
        return LEAD_LIST_VIEW_PAGE_URL;
    }

    public String getAPP_PAGE_URL() {
        return APP_PAGE_URL;
    }

    public String getNEW_LEAD_PAGE_URL() {
        return NEW_LEAD_PAGE_URL;
    }

    public String getDEFAULT_WAIT_ATTEMPTS() {
        return DEFAULT_WAIT_ATTEMPTS;
    }

    public String getBROSWER() {
        return BROWSER;
    }

    public final String DEFAULT_PAGE_LOAD_TIMES = "DEFAULT_PAGE_LOAD_TIMES";

    private static Prop INSTANCE = null;

    public String getDEFAULT_PAGE_LOAD_TIMES() {
        return DEFAULT_PAGE_LOAD_TIMES;
    }

    List<String> properties;


    public static Prop getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Prop(new File("./config.prop"));
        return INSTANCE;
    }

    private Prop(File outputFilePath) {
        this.outputFilePath = outputFilePath;
        this.properties = new ArrayList<>();

        properties.add(USER_NAME);
        properties.add(PASSWORD);
        properties.add(DEFAULT_WAIT_TIME);
        properties.add(ENVIRONMENT_URL);
        properties.add(WEB_DRIVER_PATH);
        properties.add(BROWSER);

        try (InputStream input = new FileInputStream(outputFilePath)) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveProp() {
        try (OutputStream output = new FileOutputStream(outputFilePath)) {
            for (String properties : properties) {
                prop.setProperty(properties, "TO_BE_SET");
            }
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String loadProp(String key) {
        return prop.getProperty(key);
    }


    public Properties getProp() {
        return prop;
    }

    public static void main(String[] args) {
        Prop p = new Prop(new File("./config.prop"));
        p.saveProp();
    }
}
