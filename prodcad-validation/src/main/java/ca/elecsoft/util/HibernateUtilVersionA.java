package ca.elecsoft.util;

import ca.elecsoft.model.version.twozerofourA.ProdCadAVersionA;
import ca.elecsoft.model.version.twozerofourA.ProdCadEVersionA;
import ca.elecsoft.model.version.twozerothreeE.ProdCadAVersionE;
import ca.elecsoft.model.version.twozerothreeE.ProdCadEVersionE;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateUtilVersionA {
    public static HibernateUtilVersionA INSTANCE;
    Session session;
    SessionFactory factory;

    private HibernateUtilVersionA() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
    }

    public static HibernateUtilVersionA getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateUtilVersionA();
        }
        return INSTANCE;
    }

    public static ProdCadAVersionE buildProdCadA(String split, ProdCadAVersionE a) {
        String[] b = split.split("\\|");
        int i = 0;
        a.setProductid(b[i++]);
        a.setSbnproductcode(b[i++]);
        a.setName_en_(b[i++]);
        a.setName_fr_(b[i++]);
        a.setParent(b[i++]);
        a.setDescription(b[i++]);
        a.setDescription_fr_(b[i++]);
        a.setTechnicaldescription(b[i++]);
        a.setTechnicaldescription_fr_(b[i++]);
        a.setPanelid(b[i++]);
        a.setUpccode(b[i++]);
        a.setFieldserviceproducttype(b[i++]);
        a.setAddtocustomerasset_service_(b[i++]);
        a.setProductstructure(b[i++]);
        a.setProductcategory(b[i++]);
        a.setRevenuetype(b[i++]);
        a.setValidfrom(b[i++]);
        a.setValidto(b[i++]);
        a.setConverttocustomerasset(b[i++]);
        a.setCustomerprovidedequipment(b[i++]);
        a.setIndoor_outdoor(b[i++]);
        a.setUpc_scanningrequired(b[i++]);
        a.setSerializedproduct(b[i++]);
        a.setDecimalssupported(b[i++]);
        a.setDefaultpricelist(b[i++]);
        a.setDefaultunit(b[i++]);
        a.setLegacyitem(b[i++]);
        a.setStatus(b[i++]);
        a.setStatusreason(b[i++]);
        a.setUnitgroup(b[i++]);
        a.setSagedepletioncode(b[i++]);
        a.setSagereturncode(b[i++]);
        a.setBrc(b[i++]);
        a.setComponent(b[i++]);
        a.setDatecontrolledpromotion(b[i++]);
        a.setPromotionlength_months_(b[i++]);
        a.setExpirationdetailsrequired(b[i++]);
        a.setShelflife_month_(b[i++]);
        a.setPromotion_offertype(b[i++]);
        a.setMailout(b[i++]);
        a.setCurrency(b[i++]);
        a.setMedicalitem(b[i++]);
        a.setDummyproduct(b[i++]);
        a.setProcessid(b[i++]);
        a.setSensor(b[i++]);
        a.setActivatestackingfunctionality(b[i++]);
        a.setStackinggroup(b[i++]);
        a.setBundlespecification(b[i++]);
        a.setBundletype(b[i++]);
        a.setSelfinstall(b[i++]);
        a.setBundletier(b[i++]);
        a.setDateControlledService(b[i++]);
        return a;
    }


    public void storeListProdCadE(String split, ProdCadEVersionA object) {
        Transaction t = session.beginTransaction();
        session.save(object);
        t.commit();

    }

    public static ProdCadEVersionA buildProdCad(String split, ProdCadEVersionA a) {
        String[] b = split.split("\\|");
        int i = 0;
        a.setProductid(b[i++]);
        a.setSbnid(b[i++]);
        a.setName(b[i++]);
        a.setName_fr_(b[i++]);
        a.setParentproductid(b[i++]);
        a.setDescription(b[i++]);
        a.setDescription_fr_(b[i++]);
        a.setTechnicaldescription(b[i++]);
        a.setTechnicaldescription_fr_(b[i++]);
        a.setPanelid(b[i++]);
        a.setUpccode(b[i++]);
        a.setFieldserviceproducttype(b[i++]);
        a.setAddtocustomerasset(b[i++]);
        a.setProductstructure(b[i++]);
        a.setProductcategory(b[i++]);
        a.setRevenuetype(b[i++]);
        a.setValidfrom(b[i++]);
        a.setValidto(b[i++]);
        a.setConverttocustomerasset(b[i++]);
        a.setCpe(b[i++]);
        a.setIndoor_outdoor(b[i++]);
        a.setUpclookup(b[i++]);
        a.setSerializedproduct(b[i++]);
        a.setDecimalssupported(b[i++]);
        a.setDefaultpricelist(b[i++]);
        a.setDefaultunit(b[i++]);
        a.setLegacyitem(b[i++]);
        a.setStatus(b[i++]);
        a.setStatusreason(b[i++]);
        a.setUnitgroup(b[i++]);
        a.setSagedepletioncode(b[i++]);
        a.setSagereturncode(b[i++]);
        a.setBrc(b[i++]);
        a.setSbncomponentflag(b[i++]);
        a.setDatecontrolledpromo(b[i++]);
        a.setPromotionlength(b[i++]);
        a.setLifesafeyflag(b[i++]);
        a.setLifesafetylength(b[i++]);
        a.setPromotion_offertype(b[i++]);
        a.setMailout_y_n_(b[i++]);
        a.setLegacy_y_n_(b[i++]);
        a.setMedicalitem_y_n_(b[i++]);
        a.setDummybundle(b[i++]);
        a.setSbnproductid_forpackages_(b[i++]);
        a.setLegacysensors(b[i++]);
        a.setActivatestacking(b[i++]);
        a.setStackinggroup(b[i++]);
        a.setBundlespecification(b[i++]);
        a.setBundletype(b[i++]);
        a.setSelfinstalleligible(b[i++]);
        a.setBundletier(b[i++]);
        a.setDateControlledService(b[i++]);
        return a;
    }


    /**
     * @return this will return all rows in the expected product catalogue
     */
    public List<ProdCadEVersionA> displayAllProdCadE() {
        Transaction t = session.beginTransaction();
        List<ProdCadEVersionA> list = (List<ProdCadEVersionA>) session.createQuery(
                "FROM ProdCadE").getResultList();
        list.remove(0);
        t.commit();
        try {
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param productCode the id of the product
     * @return this will return the actual product for a given product code or null if it does not exist
     */
    public ProdCadAVersionA getOneProdCadA(String productCode) {
        List<ProdCadAVersionA> list = (List<ProdCadAVersionA>) session.createQuery(
                "FROM ProdCadA where Productid = '" + productCode + "'").getResultList();
        try {
            System.out.println(list);
            return list.get(0);
        } catch (Exception e) {
            return null;
        }
    }



    public ProdCadEVersionA getOneProdCadE(String productCode) {
        Transaction t = session.beginTransaction();
        ProdCadEVersionA e = session.get(ProdCadEVersionA.class, productCode);
        t.commit();
        return e;
    }






}
