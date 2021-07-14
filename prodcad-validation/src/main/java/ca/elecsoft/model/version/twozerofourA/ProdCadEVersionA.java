package ca.elecsoft.model.version.twozerofourA;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdCadEVersionA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prodcadid;

    String Productid;
    String Sbnid;
    String Name;
    String Name_fr_;
    String Parentproductid;
    String Description;
    String Description_fr_;
    String Technicaldescription;
    String Technicaldescription_fr_;
    String Panelid;
    String Upccode;
    String Fieldserviceproducttype;
    String Addtocustomerasset;
    String Productstructure;
    String Productcategory;
    String Revenuetype;
    String Validfrom;
    String Validto;
    String Converttocustomerasset;
    String Cpe;
    String Indoor_outdoor;
    String Upclookup;
    String Serializedproduct;
    String Decimalssupported;
    String Defaultpricelist;
    String Defaultunit;
    String Legacyitem;
    String Status;
    String Statusreason;
    String Unitgroup;
    String Sagedepletioncode;
    String Sagereturncode;
    String Brc;
    String Sbncomponentflag;
    String Datecontrolledpromo;
    String Promotionlength;
    String Lifesafeyflag;
    String Lifesafetylength;
    String Promotion_offertype;
    String Mailout_y_n_;
    String Legacy_y_n_;
    String Medicalitem_y_n_;
    String Dummybundle;
    String Sbnproductid_forpackages_;
    String Legacysensors;
    String Activatestacking;
    String Stackinggroup;
    String Bundlespecification;
    String Bundletype;
    String Selfinstalleligible;
    String Bundletier;
    String dateControlledService;

    public String getDateControlledService() {
        return dateControlledService;
    }

    public void setDateControlledService(String dateControlledService) {
        this.dateControlledService = dateControlledService;
    }

    public int getProdcadid() {
        return prodcadid;
    }

    public void setProdcadid(int prodcadid) {
        this.prodcadid = prodcadid;
    }

    public String getProductid() {
        return Productid;
    }

    public void setProductid(String productid) {
        Productid = productid;
    }

    public String getSbnid() {
        return Sbnid;
    }

    public void setSbnid(String sbnid) {
        Sbnid = sbnid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName_fr_() {
        return Name_fr_;
    }

    public void setName_fr_(String name_fr_) {
        Name_fr_ = name_fr_;
    }

    public String getParentproductid() {
        return Parentproductid;
    }

    public void setParentproductid(String parentproductid) {
        Parentproductid = parentproductid;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription_fr_() {
        return Description_fr_;
    }

    public void setDescription_fr_(String description_fr_) {
        Description_fr_ = description_fr_;
    }

    public String getTechnicaldescription() {
        return Technicaldescription;
    }

    public void setTechnicaldescription(String technicaldescription) {
        Technicaldescription = technicaldescription;
    }

    public String getTechnicaldescription_fr_() {
        return Technicaldescription_fr_;
    }

    public void setTechnicaldescription_fr_(String technicaldescription_fr_) {
        Technicaldescription_fr_ = technicaldescription_fr_;
    }

    public String getPanelid() {
        return Panelid;
    }

    public void setPanelid(String panelid) {
        Panelid = panelid;
    }

    public String getUpccode() {
        return Upccode;
    }

    public void setUpccode(String upccode) {
        Upccode = upccode;
    }

    public String getFieldserviceproducttype() {
        return Fieldserviceproducttype;
    }

    public void setFieldserviceproducttype(String fieldserviceproducttype) {
        Fieldserviceproducttype = fieldserviceproducttype;
    }

    public String getAddtocustomerasset() {
        return Addtocustomerasset;
    }

    public void setAddtocustomerasset(String addtocustomerasset) {
        Addtocustomerasset = addtocustomerasset;
    }

    public String getProductstructure() {
        return Productstructure;
    }

    public void setProductstructure(String productstructure) {
        Productstructure = productstructure;
    }

    public String getProductcategory() {
        return Productcategory;
    }

    public void setProductcategory(String productcategory) {
        Productcategory = productcategory;
    }

    public String getRevenuetype() {
        return Revenuetype;
    }

    public void setRevenuetype(String revenuetype) {
        Revenuetype = revenuetype;
    }

    public String getValidfrom() {
        return Validfrom;
    }

    public void setValidfrom(String validfrom) {
        Validfrom = validfrom;
    }

    public String getValidto() {
        return Validto;
    }

    public void setValidto(String validto) {
        Validto = validto;
    }

    public String getConverttocustomerasset() {
        return Converttocustomerasset;
    }

    public void setConverttocustomerasset(String converttocustomerasset) {
        Converttocustomerasset = converttocustomerasset;
    }

    public String getCpe() {
        return Cpe;
    }

    public void setCpe(String cpe) {
        Cpe = cpe;
    }

    public String getIndoor_outdoor() {
        return Indoor_outdoor;
    }

    public void setIndoor_outdoor(String indoor_outdoor) {
        Indoor_outdoor = indoor_outdoor;
    }

    public String getUpclookup() {
        return Upclookup;
    }

    public void setUpclookup(String upclookup) {
        Upclookup = upclookup;
    }

    public String getSerializedproduct() {
        return Serializedproduct;
    }

    public void setSerializedproduct(String serializedproduct) {
        Serializedproduct = serializedproduct;
    }

    public String getDecimalssupported() {
        return Decimalssupported;
    }

    public void setDecimalssupported(String decimalssupported) {
        Decimalssupported = decimalssupported;
    }

    public String getDefaultpricelist() {
        return Defaultpricelist;
    }

    public void setDefaultpricelist(String defaultpricelist) {
        Defaultpricelist = defaultpricelist;
    }

    public String getDefaultunit() {
        return Defaultunit;
    }

    public void setDefaultunit(String defaultunit) {
        Defaultunit = defaultunit;
    }

    public String getLegacyitem() {
        return Legacyitem;
    }

    public void setLegacyitem(String legacyitem) {
        Legacyitem = legacyitem;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatusreason() {
        return Statusreason;
    }

    public void setStatusreason(String statusreason) {
        Statusreason = statusreason;
    }

    public String getUnitgroup() {
        return Unitgroup;
    }

    public void setUnitgroup(String unitgroup) {
        Unitgroup = unitgroup;
    }

    public String getSagedepletioncode() {
        return Sagedepletioncode;
    }

    public void setSagedepletioncode(String sagedepletioncode) {
        Sagedepletioncode = sagedepletioncode;
    }

    public String getSagereturncode() {
        return Sagereturncode;
    }

    public void setSagereturncode(String sagereturncode) {
        Sagereturncode = sagereturncode;
    }

    public String getBrc() {
        return Brc;
    }

    public void setBrc(String brc) {
        Brc = brc;
    }

    public String getSbncomponentflag() {
        return Sbncomponentflag;
    }

    public void setSbncomponentflag(String sbncomponentflag) {
        Sbncomponentflag = sbncomponentflag;
    }

    public String getDatecontrolledpromo() {
        return Datecontrolledpromo;
    }

    public void setDatecontrolledpromo(String datecontrolledpromo) {
        Datecontrolledpromo = datecontrolledpromo;
    }

    public String getPromotionlength() {
        return Promotionlength;
    }

    public void setPromotionlength(String promotionlength) {
        Promotionlength = promotionlength;
    }

    public String getLifesafeyflag() {
        return Lifesafeyflag;
    }

    public void setLifesafeyflag(String lifesafeyflag) {
        Lifesafeyflag = lifesafeyflag;
    }

    public String getLifesafetylength() {
        return Lifesafetylength;
    }

    public void setLifesafetylength(String lifesafetylength) {
        Lifesafetylength = lifesafetylength;
    }

    public String getPromotion_offertype() {
        return Promotion_offertype;
    }

    public void setPromotion_offertype(String promotion_offertype) {
        Promotion_offertype = promotion_offertype;
    }

    public String getMailout_y_n_() {
        return Mailout_y_n_;
    }

    public void setMailout_y_n_(String mailout_y_n_) {
        Mailout_y_n_ = mailout_y_n_;
    }

    public String getLegacy_y_n_() {
        return Legacy_y_n_;
    }

    public void setLegacy_y_n_(String legacy_y_n_) {
        Legacy_y_n_ = legacy_y_n_;
    }

    public String getMedicalitem_y_n_() {
        return Medicalitem_y_n_;
    }

    public void setMedicalitem_y_n_(String medicalitem_y_n_) {
        Medicalitem_y_n_ = medicalitem_y_n_;
    }

    public String getDummybundle() {
        return Dummybundle;
    }

    public void setDummybundle(String dummybundle) {
        Dummybundle = dummybundle;
    }

    public String getSbnproductid_forpackages_() {
        return Sbnproductid_forpackages_;
    }

    public void setSbnproductid_forpackages_(String sbnproductid_forpackages_) {
        Sbnproductid_forpackages_ = sbnproductid_forpackages_;
    }

    public String getLegacysensors() {
        return Legacysensors;
    }

    public void setLegacysensors(String legacysensors) {
        Legacysensors = legacysensors;
    }

    public String getActivatestacking() {
        return Activatestacking;
    }

    public void setActivatestacking(String activatestacking) {
        Activatestacking = activatestacking;
    }

    public String getStackinggroup() {
        return Stackinggroup;
    }

    public void setStackinggroup(String stackinggroup) {
        Stackinggroup = stackinggroup;
    }

    public String getBundlespecification() {
        return Bundlespecification;
    }

    public void setBundlespecification(String bundlespecification) {
        Bundlespecification = bundlespecification;
    }

    public String getBundletype() {
        return Bundletype;
    }

    public void setBundletype(String bundletype) {
        Bundletype = bundletype;
    }

    public String getSelfinstalleligible() {
        return Selfinstalleligible;
    }

    public void setSelfinstalleligible(String selfinstalleligible) {
        Selfinstalleligible = selfinstalleligible;
    }

    public String getBundletier() {
        return Bundletier;
    }

    public void setBundletier(String bundletier) {
        Bundletier = bundletier;
    }

    @Override
    public String
    toString() {
        return "ProdCadE{" +
                "prodcadid=" + prodcadid +
                ", Productid='" + Productid + '\'' +
                ", Sbnid='" + Sbnid + '\'' +
                ", Name='" + Name + '\'' +
                ", Name_fr_='" + Name_fr_ + '\'' +
                ", Parentproductid='" + Parentproductid + '\'' +
                ", Description='" + Description + '\'' +
                ", Description_fr_='" + Description_fr_ + '\'' +
                ", Technicaldescription='" + Technicaldescription + '\'' +
                ", Technicaldescription_fr_='" + Technicaldescription_fr_ + '\'' +
                ", Panelid='" + Panelid + '\'' +
                ", Upccode='" + Upccode + '\'' +
                ", Fieldserviceproducttype='" + Fieldserviceproducttype + '\'' +
                ", Addtocustomerasset='" + Addtocustomerasset + '\'' +
                ", Productstructure='" + Productstructure + '\'' +
                ", Productcategory='" + Productcategory + '\'' +
                ", Revenuetype='" + Revenuetype + '\'' +
                ", Validfrom='" + Validfrom + '\'' +
                ", Validto='" + Validto + '\'' +
                ", Converttocustomerasset='" + Converttocustomerasset + '\'' +
                ", Cpe='" + Cpe + '\'' +
                ", Indoor_outdoor='" + Indoor_outdoor + '\'' +
                ", Upclookup='" + Upclookup + '\'' +
                ", Serializedproduct='" + Serializedproduct + '\'' +
                ", Decimalssupported='" + Decimalssupported + '\'' +
                ", Defaultpricelist='" + Defaultpricelist + '\'' +
                ", Defaultunit='" + Defaultunit + '\'' +
                ", Legacyitem='" + Legacyitem + '\'' +
                ", Status='" + Status + '\'' +
                ", Statusreason='" + Statusreason + '\'' +
                ", Unitgroup='" + Unitgroup + '\'' +
                ", Sagedepletioncode='" + Sagedepletioncode + '\'' +
                ", Sagereturncode='" + Sagereturncode + '\'' +
                ", Brc='" + Brc + '\'' +
                ", Sbncomponentflag='" + Sbncomponentflag + '\'' +
                ", Datecontrolledpromo='" + Datecontrolledpromo + '\'' +
                ", Promotionlength='" + Promotionlength + '\'' +
                ", Lifesafeyflag='" + Lifesafeyflag + '\'' +
                ", Lifesafetylength='" + Lifesafetylength + '\'' +
                ", Promotion_offertype='" + Promotion_offertype + '\'' +
                ", Mailout_y_n_='" + Mailout_y_n_ + '\'' +
                ", Legacy_y_n_='" + Legacy_y_n_ + '\'' +
                ", Medicalitem_y_n_='" + Medicalitem_y_n_ + '\'' +
                ", Dummybundle='" + Dummybundle + '\'' +
                ", Sbnproductid_forpackages_='" + Sbnproductid_forpackages_ + '\'' +
                ", Legacysensors='" + Legacysensors + '\'' +
                ", Activatestacking='" + Activatestacking + '\'' +
                ", Stackinggroup='" + Stackinggroup + '\'' +
                ", Bundlespecification='" + Bundlespecification + '\'' +
                ", Bundletype='" + Bundletype + '\'' +
                ", Selfinstalleligible='" + Selfinstalleligible + '\'' +
                ", Bundletier='" + Bundletier + '\'' +
                '}';
    }
}
