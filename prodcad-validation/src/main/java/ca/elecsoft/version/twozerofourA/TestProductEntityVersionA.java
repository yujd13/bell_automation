package ca.elecsoft.version.twozerofourA;

import ca.elecsoft.model.version.twozerofourA.ProdCadAVersionA;
import ca.elecsoft.model.version.twozerofourA.ProdCadEVersionA;
import ca.elecsoft.model.version.twozerothreeE.ProdCadAVersionE;
import ca.elecsoft.model.version.twozerothreeE.ProdCadEVersionE;
import ca.elecsoft.util.HibernateUtilVersionA;
import ca.elecsoft.util.HibernateUtilVersionE;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;


/**
 * This class is responsible for testing validating if the product catalogue is correct
 */
public class TestProductEntityVersionA {
    List<ProdCadEVersionA> listE;


    /**
     * This function is for performing the product field comparisons
     */
    @Test
    public void testProdCad() {
        HibernateUtilVersionA util = HibernateUtilVersionA.getINSTANCE();
        List<ProdCadEVersionA> list = util.displayAllProdCadE();
        Reporter.log("Product Code| Sheet Product Property | CRM Product Property | Actual | Expected | Pass/Fail");
        for (ProdCadEVersionA e : list) {
            String productId = e.getProductid();
            System.out.println(productId);
            ProdCadAVersionA a = util.getOneProdCadA(productId);
            if (a != null && e != null) {
                Boolean ProductidB = a.getProductid().trim().toLowerCase().equals(e.getProductid().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Product ID" + "|" + "Product ID" + "|" + a.getProductid() + "|" + e.getProductid() + "|" + ProductidB);
                Boolean SbnproductcodeB = a.getSbnproductcode().trim().toLowerCase().equals(e.getSbnid().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "SBN ID" + "|" + "SBN Product Code" + "|" + a.getSbnproductcode() + "|" + e.getSbnid() + "|" + SbnproductcodeB);
                Boolean Name_en_B = a.getName_en_().trim().toLowerCase().equals(e.getName().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Name" + "|" + "Name (EN)" + "|" + a.getName_en_() + "|" + e.getName() + "|" + Name_en_B);
                Boolean Name_fr_B = a.getName_fr_().trim().toLowerCase().equals(e.getName_fr_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Name (FR)" + "|" + "Name (FR)" + "|" + a.getName_fr_() + "|" + e.getName_fr_() + "|" + Name_fr_B);
                Boolean ParentB = a.getParent().trim().toLowerCase().equals(e.getParentproductid().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Parent Product ID" + "|" + "Parent" + "|" + a.getParent() + "|" + e.getParentproductid() + "|" + ParentB);
                Boolean DescriptionB = a.getDescription().trim().toLowerCase().equals(e.getDescription().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Description" + "|" + "Description" + "|" + a.getDescription() + "|" + e.getDescription() + "|" + DescriptionB);
                Boolean Description_fr_B = a.getDescription_fr_().trim().toLowerCase().equals(e.getDescription_fr_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Description (FR)" + "|" + "Description (FR)" + "|" + a.getDescription_fr_() + "|" + e.getDescription_fr_() + "|" + Description_fr_B);
                Boolean TechnicaldescriptionB = a.getTechnicaldescription().trim().toLowerCase().equals(e.getTechnicaldescription().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Technical Description" + "|" + "Technical Description" + "|" + a.getTechnicaldescription() + "|" + e.getTechnicaldescription() + "|" + TechnicaldescriptionB);
                Boolean Technicaldescription_fr_B = a.getTechnicaldescription_fr_().trim().toLowerCase().equals(e.getTechnicaldescription_fr_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Technical Description (FR)" + "|" + "Technical Description (FR)" + "|" + a.getTechnicaldescription_fr_() + "|" + e.getTechnicaldescription_fr_() + "|" + Technicaldescription_fr_B);
                Boolean PanelidB = a.getPanelid().trim().toLowerCase().equals(e.getPanelid().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Panel ID" + "|" + "Panel ID" + "|" + a.getPanelid() + "|" + e.getPanelid() + "|" + PanelidB);
                Boolean UpccodeB = a.getUpccode().trim().toLowerCase().equals(e.getUpccode().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "UPC Code" + "|" + "UPC Code" + "|" + a.getUpccode() + "|" + e.getUpccode() + "|" + UpccodeB);
                Boolean FieldserviceproducttypeB = a.getFieldserviceproducttype().trim().toLowerCase().equals(e.getFieldserviceproducttype().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Field Service Product Type" + "|" + "Field Service Product Type" + "|" + a.getFieldserviceproducttype() + "|" + e.getFieldserviceproducttype() + "|" + FieldserviceproducttypeB);
                Boolean Addtocustomerasset_service_B = a.getAddtocustomerasset_service_().trim().toLowerCase().equals(e.getAddtocustomerasset().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Add To Customer Asset" + "|" + "Add to Customer Asset (Service)" + "|" + a.getAddtocustomerasset_service_() + "|" + e.getAddtocustomerasset() + "|" + Addtocustomerasset_service_B);
                Boolean ProductstructureB = a.getProductstructure().trim().toLowerCase().equals(e.getProductstructure().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Product Structure" + "|" + "Product Structure" + "|" + a.getProductstructure() + "|" + e.getProductstructure() + "|" + ProductstructureB);
                Boolean ProductcategoryB = a.getProductcategory().trim().toLowerCase().equals(e.getProductcategory().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Product Category" + "|" + "Product Category" + "|" + a.getProductcategory() + "|" + e.getProductcategory() + "|" + ProductcategoryB);
                Boolean RevenuetypeB = a.getRevenuetype().trim().toLowerCase().equals(e.getRevenuetype().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Revenue Type" + "|" + "Revenue Type" + "|" + a.getRevenuetype() + "|" + e.getRevenuetype() + "|" + RevenuetypeB);
                Boolean ValidfromB = a.getValidfrom().trim().toLowerCase().equals(e.getValidfrom().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Valid From" + "|" + "Valid From" + "|" + a.getValidfrom() + "|" + e.getValidfrom() + "|" + ValidfromB);
                Boolean ValidtoB = a.getValidto().trim().toLowerCase().equals(e.getValidto().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Valid To" + "|" + "Valid To" + "|" + a.getValidto() + "|" + e.getValidto() + "|" + ValidtoB);
                Boolean ConverttocustomerassetB = a.getConverttocustomerasset().trim().toLowerCase().equals(e.getConverttocustomerasset().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Convert to Customer Asset" + "|" + "Convert to Customer Asset" + "|" + a.getConverttocustomerasset() + "|" + e.getConverttocustomerasset() + "|" + ConverttocustomerassetB);
                Boolean CustomerprovidedequipmentB = a.getCustomerprovidedequipment().trim().toLowerCase().equals(e.getCpe().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "CPE" + "|" + "Customer Provided Equipment" + "|" + a.getCustomerprovidedequipment() + "|" + e.getCpe() + "|" + CustomerprovidedequipmentB);
                Boolean Indoor_outdoorB = a.getIndoor_outdoor().trim().toLowerCase().equals(e.getIndoor_outdoor().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Indoor/Outdoor" + "|" + "Indoor/Outdoor" + "|" + a.getIndoor_outdoor() + "|" + e.getIndoor_outdoor() + "|" + Indoor_outdoorB);
                Boolean Upc_scanningrequiredB = a.getUpc_scanningrequired().trim().toLowerCase().equals(e.getUpclookup().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "UPC Lookup" + "|" + "UPC-scanning required" + "|" + a.getUpc_scanningrequired() + "|" + e.getUpclookup() + "|" + Upc_scanningrequiredB);
                Boolean SerializedproductB = a.getSerializedproduct().trim().toLowerCase().equals(e.getSerializedproduct().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Serialized Product" + "|" + "Serialized Product" + "|" + a.getSerializedproduct() + "|" + e.getSerializedproduct() + "|" + SerializedproductB);
                Boolean DecimalssupportedB = a.getDecimalssupported().trim().toLowerCase().equals(e.getDecimalssupported().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Decimals Supported" + "|" + "Decimals Supported" + "|" + a.getDecimalssupported() + "|" + e.getDecimalssupported() + "|" + DecimalssupportedB);
                Boolean DefaultpricelistB = a.getDefaultpricelist().trim().toLowerCase().equals(e.getDefaultpricelist().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Default Price List" + "|" + "Default Price List" + "|" + a.getDefaultpricelist() + "|" + e.getDefaultpricelist() + "|" + DefaultpricelistB);
                Boolean DefaultunitB = a.getDefaultunit().trim().toLowerCase().equals(e.getDefaultunit().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Default Unit" + "|" + "Default Unit" + "|" + a.getDefaultunit() + "|" + e.getDefaultunit() + "|" + DefaultunitB);
                Boolean LegacyitemB = a.getLegacyitem().trim().toLowerCase().equals(e.getLegacyitem().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Legacy Item" + "|" + "Legacy Item" + "|" + a.getLegacyitem() + "|" + e.getLegacyitem() + "|" + LegacyitemB);
                Boolean StatusB = a.getStatus().trim().toLowerCase().equals(e.getStatus().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Status" + "|" + "Status" + "|" + a.getStatus() + "|" + e.getStatus() + "|" + StatusB);
                Boolean StatusreasonB = a.getStatusreason().trim().toLowerCase().equals(e.getStatusreason().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Status Reason" + "|" + "Status Reason" + "|" + a.getStatusreason() + "|" + e.getStatusreason() + "|" + StatusreasonB);
                Boolean UnitgroupB = a.getUnitgroup().trim().toLowerCase().equals(e.getUnitgroup().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Unit Group" + "|" + "Unit Group" + "|" + a.getUnitgroup() + "|" + e.getUnitgroup() + "|" + UnitgroupB);
                Boolean SagedepletioncodeB = a.getSagedepletioncode().trim().toLowerCase().equals(e.getSagedepletioncode().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Sage Depletion Code" + "|" + "Sage Depletion Code" + "|" + a.getSagedepletioncode() + "|" + e.getSagedepletioncode() + "|" + SagedepletioncodeB);
                Boolean SagereturncodeB = a.getSagereturncode().trim().toLowerCase().equals(e.getSagereturncode().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Sage Return Code" + "|" + "SAGE Return Code" + "|" + a.getSagereturncode() + "|" + e.getSagereturncode() + "|" + SagereturncodeB);
                Boolean BrcB = a.getBrc().trim().toLowerCase().equals(e.getBrc().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "BRC" + "|" + "BRC" + "|" + a.getBrc() + "|" + e.getBrc() + "|" + BrcB);
                Boolean ComponentB = a.getComponent().trim().toLowerCase().equals(e.getSbncomponentflag().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "SBN Component Flag" + "|" + "Component" + "|" + a.getComponent() + "|" + e.getSbncomponentflag() + "|" + ComponentB);
                Boolean DatecontrolledpromotionB = a.getDatecontrolledpromotion().trim().toLowerCase().equals(e.getDatecontrolledpromo().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "DATE CONTROLLED PROMO" + "|" + "Date controlled promotion" + "|" + a.getDatecontrolledpromotion() + "|" + e.getDatecontrolledpromo() + "|" + DatecontrolledpromotionB);
                Boolean Promotionlength_months_B = a.getPromotionlength_months_().trim().toLowerCase().equals(e.getPromotionlength().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "PROMOTION LENGTH" + "|" + "Promotion length (Months)" + "|" + a.getPromotionlength_months_() + "|" + e.getPromotionlength() + "|" + Promotionlength_months_B);
                Boolean ExpirationdetailsrequiredB = a.getExpirationdetailsrequired().trim().toLowerCase().equals(e.getLifesafeyflag().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Life Safey Flag" + "|" + "Expiration Details Required" + "|" + a.getExpirationdetailsrequired() + "|" + e.getLifesafeyflag() + "|" + ExpirationdetailsrequiredB);
                Boolean Shelflife_month_B = a.getShelflife_month_().trim().toLowerCase().equals(e.getLifesafetylength().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Life Safety Length" + "|" + "Shelf life (Month)" + "|" + a.getShelflife_month_() + "|" + e.getLifesafetylength() + "|" + Shelflife_month_B);
                Boolean Promotion_offertypeB = a.getPromotion_offertype().trim().toLowerCase().equals(e.getPromotion_offertype().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Promotion / Offer Type" + "|" + "Promotion / offer type" + "|" + a.getPromotion_offertype() + "|" + e.getPromotion_offertype() + "|" + Promotion_offertypeB);
                Boolean MailoutB = a.getMailout().trim().toLowerCase().equals(e.getMailout_y_n_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Mailout (Y/N)" + "|" + "Mailout" + "|" + a.getMailout() + "|" + e.getMailout_y_n_() + "|" + MailoutB);
                Boolean CurrencyB = a.getLegacyitem().trim().toLowerCase().equals(e.getLegacy_y_n_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Legacy (Y/N)" + "|" + "Legacy" + "|" + a.getLegacyitem() + "|" + e.getLegacy_y_n_() + "|" + CurrencyB);
                Boolean MedicalitemB = a.getMedicalitem().trim().toLowerCase().equals(e.getMedicalitem_y_n_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Medical Item (Y/N)" + "|" + "Medical Item" + "|" + a.getMedicalitem() + "|" + e.getMedicalitem_y_n_() + "|" + MedicalitemB);
                Boolean DummyproductB = a.getDummyproduct().trim().toLowerCase().equals(e.getDummybundle().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Dummy Bundle" + "|" + "Dummy Product" + "|" + a.getDummyproduct() + "|" + e.getDummybundle() + "|" + DummyproductB);
                Boolean ProcessidB = a.getProcessid().trim().toLowerCase().equals(e.getSbnproductid_forpackages_().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "SBN Product ID (for Packages)" + "|" + "Process Id" + "|" + a.getProcessid() + "|" + e.getSbnproductid_forpackages_() + "|" + ProcessidB);
                Boolean SensorB = a.getSensor().trim().toLowerCase().equals(e.getLegacysensors().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Legacy Sensors" + "|" + "Sensor" + "|" + a.getSensor() + "|" + e.getLegacysensors() + "|" + SensorB);
                Boolean ActivatestackingfunctionalityB = a.getActivatestackingfunctionality().trim().toLowerCase().equals(e.getActivatestacking().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Activate Stacking" + "|" + "Activate Stacking Functionality" + "|" + a.getActivatestackingfunctionality() + "|" + e.getActivatestacking() + "|" + ActivatestackingfunctionalityB);
                Boolean StackinggroupB = a.getStackinggroup().trim().toLowerCase().equals(e.getStackinggroup().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Stacking Group" + "|" + "Stacking Group" + "|" + a.getStackinggroup() + "|" + e.getStackinggroup() + "|" + StackinggroupB);
                Boolean BundlespecificationB = a.getBundlespecification().trim().toLowerCase().equals(e.getBundlespecification().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Bundle Specification" + "|" + "Bundle Specification" + "|" + a.getBundlespecification() + "|" + e.getBundlespecification() + "|" + BundlespecificationB);
                Boolean BundletypeB = a.getBundletype().trim().toLowerCase().equals(e.getBundletype().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Bundle Type" + "|" + "Bundle Type" + "|" + a.getBundletype() + "|" + e.getBundletype() + "|" + BundletypeB);
                Boolean SelfinstallB = a.getSelfinstall().trim().toLowerCase().equals(e.getSelfinstalleligible().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Self Install Eligible" + "|" + "Self Install" + "|" + a.getSelfinstall() + "|" + e.getSelfinstalleligible() + "|" + SelfinstallB);
                Boolean BundletierB = a.getBundletier().trim().toLowerCase().equals(e.getBundletier().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Bundle Tier" + "|" + "Bundle Tier" + "|" + a.getBundletier() + "|" + e.getBundletier() + "|" + BundletierB);

                Boolean dateControlledService = a.getDateControlledService().trim().toLowerCase().equals(e.getDateControlledService().trim().toLowerCase());
                Reporter.log(e.getProductid() + "|" + "Date Controlled Service" + "|" + "Date Controlled Service" + "|" + a.getDateControlledService() + "|" + e.getDateControlledService() + "|" + dateControlledService);



            } else if (e != null) {
                Reporter.log(e.getProductid() + "|" + "Product ID" + "|" + "MISSING" + "|" + e.getProductid() + "|" + "false");
            }

            Assert.assertEquals(0, 0);

        }
    }

}
