package ca.elecsoft.model.version.twozerofourA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdCadAVersionA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prodcadid;

    String Productid;
    String Sbnproductcode;
    String Name_en_;
    String Name_fr_;
    String Description;
    String Parent;
    String Description_fr_;
    String Technicaldescription;
    String Technicaldescription_fr_;
    String Panelid;
    String Upccode;
    String Fieldserviceproducttype;
    String Addtocustomerasset_service_;
    String Productstructure;
    String Productcategory;
    String Revenuetype;
    String Validfrom;
    String Validto;
    String Converttocustomerasset;
    String Customerprovidedequipment;
    String Indoor_outdoor;
    String Upc_scanningrequired;
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
    String Component;
    String Datecontrolledpromotion;
    String Promotionlength_months_;
    String Expirationdetailsrequired;
    String Shelflife_month_;
    String Promotion_offertype;
    String Mailout;
    String Currency;
    String Medicalitem;
    String Dummyproduct;
    String Processid;
    String Sensor;
    String Activatestackingfunctionality;
    String Stackinggroup;
    String Bundlespecification;
    String Bundletype;
    String Selfinstall;
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

    public String getSbnproductcode() {
        return Sbnproductcode;
    }

    public void setSbnproductcode(String sbnproductcode) {
        Sbnproductcode = sbnproductcode;
    }

    public String getName_en_() {
        return Name_en_;
    }

    public void setName_en_(String name_en_) {
        Name_en_ = name_en_;
    }

    public String getName_fr_() {
        return Name_fr_;
    }

    public void setName_fr_(String name_fr_) {
        Name_fr_ = name_fr_;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getParent() {
        return Parent;
    }

    public void setParent(String parent) {
        Parent = parent;
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

    public String getAddtocustomerasset_service_() {
        return Addtocustomerasset_service_;
    }

    public void setAddtocustomerasset_service_(String addtocustomerasset_service_) {
        Addtocustomerasset_service_ = addtocustomerasset_service_;
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

    public String getCustomerprovidedequipment() {
        return Customerprovidedequipment;
    }

    public void setCustomerprovidedequipment(String customerprovidedequipment) {
        Customerprovidedequipment = customerprovidedequipment;
    }

    public String getIndoor_outdoor() {
        return Indoor_outdoor;
    }

    public void setIndoor_outdoor(String indoor_outdoor) {
        Indoor_outdoor = indoor_outdoor;
    }

    public String getUpc_scanningrequired() {
        return Upc_scanningrequired;
    }

    public void setUpc_scanningrequired(String upc_scanningrequired) {
        Upc_scanningrequired = upc_scanningrequired;
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

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public String getDatecontrolledpromotion() {
        return Datecontrolledpromotion;
    }

    public void setDatecontrolledpromotion(String datecontrolledpromotion) {
        Datecontrolledpromotion = datecontrolledpromotion;
    }

    public String getPromotionlength_months_() {
        return Promotionlength_months_;
    }

    public void setPromotionlength_months_(String promotionlength_months_) {
        Promotionlength_months_ = promotionlength_months_;
    }

    public String getExpirationdetailsrequired() {
        return Expirationdetailsrequired;
    }

    public void setExpirationdetailsrequired(String expirationdetailsrequired) {
        Expirationdetailsrequired = expirationdetailsrequired;
    }

    public String getShelflife_month_() {
        return Shelflife_month_;
    }

    public void setShelflife_month_(String shelflife_month_) {
        Shelflife_month_ = shelflife_month_;
    }

    public String getPromotion_offertype() {
        return Promotion_offertype;
    }

    public void setPromotion_offertype(String promotion_offertype) {
        Promotion_offertype = promotion_offertype;
    }

    public String getMailout() {
        return Mailout;
    }

    public void setMailout(String mailout) {
        Mailout = mailout;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getMedicalitem() {
        return Medicalitem;
    }

    public void setMedicalitem(String medicalitem) {
        Medicalitem = medicalitem;
    }

    public String getDummyproduct() {
        return Dummyproduct;
    }

    public void setDummyproduct(String dummyproduct) {
        Dummyproduct = dummyproduct;
    }

    public String getProcessid() {
        return Processid;
    }

    public void setProcessid(String processid) {
        Processid = processid;
    }

    public String getSensor() {
        return Sensor;
    }

    public void setSensor(String sensor) {
        Sensor = sensor;
    }

    public String getActivatestackingfunctionality() {
        return Activatestackingfunctionality;
    }

    public void setActivatestackingfunctionality(String activatestackingfunctionality) {
        Activatestackingfunctionality = activatestackingfunctionality;
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

    public String getSelfinstall() {
        return Selfinstall;
    }

    public void setSelfinstall(String selfinstall) {
        Selfinstall = selfinstall;
    }

    public String getBundletier() {
        return Bundletier;
    }

    public void setBundletier(String bundletier) {
        Bundletier = bundletier;
    }
}
