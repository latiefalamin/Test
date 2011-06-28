/*
 * created : Jun 19, 2011
 * by : Latief
 */
package latief.hotel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import latief.hotel.enumeration.JenisKamar;
import latief.hotel.enumeration.StatusKamar;
import latief.hotel.model.Kamar;
import latief.hotel.model.Tagihan;
import latief.hotel.model.Tamu;

/**
 * Class untuk operasi logic dan perhitungan dari program hotel.
 * @author Latief
 */
public class HotelController {
    
    /**
     * Daftar kamar.
     */
    private Kamar [] kamars;
    
    /**
     * Daftar Tamu
     */
    private List<Tamu> tamus;

    public HotelController() {
        tamus = new ArrayList<Tamu>();
        initDaftarKamar();
    }
    
    /**
     * init Daftar Kamar
     */
    private void initDaftarKamar(){
        kamars = new Kamar[20];
        Kamar kamar101 = new Kamar(101, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[0] = kamar101;
        Kamar kamar102 = new Kamar(102, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[1] = kamar102;
        Kamar kamar103 = new Kamar(103, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[2] = kamar103;
        Kamar kamar104 = new Kamar(104, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[3] = kamar104;
        Kamar kamar105 = new Kamar(105, StatusKamar.KOSONG, JenisKamar.SUITE);
        kamars[4] = kamar105;
        
        Kamar kamar201 = new Kamar(201, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[5] = kamar201;
        Kamar kamar202 = new Kamar(202, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[6] = kamar202;
        Kamar kamar203 = new Kamar(203, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[7] = kamar203;
        Kamar kamar204 = new Kamar(204, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[8] = kamar204;
        Kamar kamar205 = new Kamar(205, StatusKamar.KOSONG, JenisKamar.TWIN);
        kamars[9] = kamar205;
        
        Kamar kamar301 = new Kamar(301, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[10] = kamar301;
        Kamar kamar302 = new Kamar(302, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[11] = kamar302;
        Kamar kamar303 = new Kamar(303, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[12] = kamar303;
        Kamar kamar304 = new Kamar(304, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[13] = kamar304;
        Kamar kamar305 = new Kamar(305, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[14] = kamar305;
        Kamar kamar306 = new Kamar(306, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[15] = kamar306;
        Kamar kamar307 = new Kamar(307, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[16] = kamar307;
        Kamar kamar308 = new Kamar(308, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[17] = kamar308;
        Kamar kamar309 = new Kamar(309, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[18] = kamar309;
        Kamar kamar310 = new Kamar(310, StatusKamar.KOSONG, JenisKamar.SINGLE);
        kamars[19] = kamar310;
    }
    
    /**
     * Tambah Tamu.
     * @param tamu 
     */
    public void addTamu(Tamu tamu){
        if(tamu == null)
            return;
        
        //Tambah Daftar Tamu
        tamus.add(tamu);
        
        //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.ISI
        updateStatusKamar(tamu.getKamar().getNo(), StatusKamar.ISI);
    }
    
    /**
     * Hapus Tamu dari daftar.
     * @param tamu 
     */
    public void removeTamu(Tamu tamu){
        if(tamu == null)
            return;
        
        //Hapus daftar Tamu
        tamus.remove(tamu);
        
        //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.KOSONG
        updateStatusKamar(tamu.getKamar().getNo(), StatusKamar.KOSONG);
    }
    
    /**
     * Hapus Tamu dari daftar berdasarkan Kamar.
     * @param kamar 
     */
    public void removeTamu(Kamar kamar){
        if(kamar == null)
            return;
        //Hapus tamu
        removeTamu(findTamu(kamar));
    }
    
    /**
     * update StatusKamar dari daftar Kamar. 
     * Yaitu StatusKamar.ISI menjadi StatusKamar.KOSONG atau sebaliknya.
     * @param noKamar
     * @param newStatusKamar 
     */
    public void updateStatusKamar(int noKamar, StatusKamar newStatusKamar){
        if(newStatusKamar == null)
            return;
        
        //Rubah Kamar yang dipesan Tamu menjadi ber StatusKamar.ISI
        Kamar kamar = findKamar(noKamar);
        if(kamar != null)
            kamar.setStatusKamar(newStatusKamar);
    }

    /**
     * Dapatkan daftar Kamar
     * @return 
     */
    public Kamar[] getKamars() {
        return kamars;
    }

    /**
     * Dapatkan daftar Kamar
     * @return 
     */
    public List<Kamar> getListKamars() {
        List<Kamar> listKamars =  new ArrayList<Kamar>();
        listKamars.addAll(Arrays.asList(kamars));
        return listKamars;
    }
    
    /**
     * Dapatkan daftar tamu
     * @return 
     */
    public List<Tamu> getTamus() {
        return tamus;
    }
    
    /**
     * Dapatkan Daftar Tagihan dari melakukan konversi Daftar Tamu.
     * @return 
     */
    public List<Tagihan> getTagihans(){
        List<Tagihan> tagihans = new ArrayList<Tagihan>();
        for(Tamu tamu:tamus){
            Tagihan tagihan = new Tagihan();
            tagihan.setNoKamar(tamu.getKamar().getNo());
            tagihan.setJenisKamar(tamu.getKamar().getJenisKamar());
            tagihan.setNoIdentitas(tamu.getNoIdentitas());
            tagihan.setNama(tamu.getNama());
            tagihan.setCheckIn(tamu.getCheckIn());
            tagihan.setCheckOut(tamu.getCheckOut());
            tagihan.setTotalBiaya(tamu.getTotalBiaya());
            tagihans.add(tagihan);
        }
        
        return tagihans;
    }
    
    /**
     * Cari Kamar berdasarkan noKamar
     * @param noKamar
     * @return 
     */
    public Kamar findKamar(int noKamar){
        for(int i=0;i<kamars.length;i++){
            if(kamars[i].getNo() == noKamar){
                return kamars[i];
            }
        }
        return null;
    }
    
    /**
     * Dapatkan daftar Kamar yang berstatus KOSONG
     * @return 
     */
    public List<Kamar> findEmptyKamars(){
        List<Kamar> kamarsEmpty = new ArrayList<Kamar>();
        for(int i = 0;i<kamars.length;i++){
            if(kamars[i].getStatusKamar().equals(StatusKamar.KOSONG)){
                kamarsEmpty.add(kamars[i]);
            }
        }
        return kamarsEmpty;
    }
    
    /**
     * Dapatkan daftar Kamar yang berstatus ISI
     * @return 
     */
    public List<Kamar> findFullKamars(){
        List<Kamar> kamarsEmpty = new ArrayList<Kamar>();
        for(int i = 0;i<kamars.length;i++){
            if(kamars[i].getStatusKamar().equals(StatusKamar.ISI)){
                kamarsEmpty.add(kamars[i]);
            }
        }
        return kamarsEmpty;
    }
    
    
    /**
     * Cari kamar berdasarkan StatusKamarnya
     * @return 
     */
    public List<Kamar> findKamars(StatusKamar statusKamar){
        List<Kamar> kamarsEmpty = new ArrayList<Kamar>();
        for(int i = 0;i<kamars.length;i++){
            if(kamars[i].getStatusKamar().equals(statusKamar)){
                kamarsEmpty.add(kamars[i]);
            }
        }
        return kamarsEmpty;
    }
    
    /**
     * Cari Tamu berdsarkan Kamar nya
     * @param kamar
     * @return 
     */
    public Tamu findTamu(Kamar kamar){
        if(kamar == null)
            return null;
        
        for(Tamu tamu:tamus){
            if(tamu.getKamar().getNo() == kamar.getNo()){
                return tamu;
            }
        }
        return null;
    }
    
    /**
     * Hitung Total biaya sewa kamar.
     * @param kamar
     * @param in
     * @param out
     * @return 
     */
    public int calculateCost(Kamar kamar, Calendar in, Calendar out){
        //Hitung berapa hari menginap
        int day = (int)(out.getTimeInMillis() - in.getTimeInMillis()) / 86400000;
        day += 1;
        //Kalikan dengan harga kamar perhari nya.
        return kamar.getJenisKamar().getCost() * day;
    }
    
}
