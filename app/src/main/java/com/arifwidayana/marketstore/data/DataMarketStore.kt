package com.arifwidayana.marketstore.data

import com.arifwidayana.marketstore.R

object DataMarketStore {
    private val nameProduct = arrayOf(
        "Teh Rio",
        "Teh Pucuk",
        "Teh Botol",
        "Beng-Beng",
        "Cadbury Dairy Milk",
        "Silver Queen",
        "Rinso",
        "So Klin",
        "Daia",
        "Downy",
        "Tango",
        "Chitato",
        "Koko Krunch",
        "Cheetos"
    )
    private val expiredProduct = arrayOf(
        "6 Juni 2024",
        "12 Agustus 2024",
        "8 Juni 2024",
        "12 April 2023",
        "25 Juni 2023",
        "7 September 2023",
        "23 Januari 2025",
        "15 Februari 2025",
        "9 September 2025",
        "15 Mei 2025",
        "21 Juni 2023",
        "11 Maret 2023",
        "26 Desember 2023",
        "4 November 2023"
    )
    private val descProduct = arrayOf(
        "Teh Rio merupakan minuman teh manis berkualitas dalam kemasan gelas yang siap dan praktis untuk diminum. Tanpa pemanis buatan dan kandungan gula yang pas, TEH RIO dikemas dengan menggunakan teknologi “Nano Seal Advance” untuk menjamin kemasan agar tidak bocor dan isi tetap terjaga.",
        "Teh Pucuk Harum, produk minuman teh dari Mayora. Minuman ini dibuat dari pucuk daun teh pilihan, bagian terbaik untuk membuat minuman teh. Produk teh ini dipadukan dengan aroma jasmine untuk menciptakan rasa teh yang terbaik. Produk minuman ini dikemas praktis, sehingga mudah dibawa kemana saja.",
        "Tehbotol Sosro diproduksi oleh PT Sinar Sosro. Di laman resminya, Sinar Sosro adalah perusahaan teh siap minum dalam kemasan botol yang pertama di Indonesia dan di dunia. Sejarah Tehbotol Sosro dimulai sejak 1969 oleh keluarga Sosrodjojo.",
        "Beng Beng adalah makanan ringan yang terkenal dengan variannya yaitu Beng Beng Wafer Coklat dari Mayora. Memiliki tekstur crunchy, wafer satu ini juga hadir dengan berbagai pilihan rasa, mulai dari coklat, hazelnut, white, bahkan minuman instan.",
        "Cadbury Dairy Milk memiliki paduan coklat krim lezat dengan potongan biskuit dan krispi yang renyah dapat dinikmati bersama oleh orangtua maupun anak. Selain itu dalam tiap kemasan Cadbury Dairy Milk terdapat serial serial mainan yang dapat dimainkan bersama sebagai upaya dalam menciptakan momen kebersamaan.",
        "Silver Queen Fruit and Nut adalah salah satu varian cokelat SilverQueen Classic. Kelezatan SilverQueen chocolate ini dihasilkan dari perpaduan yang pas antara cokelat, susu, kacang almond dan buah kering di dalamnya. Perpaduannya yang tepat menghasilkan pengalaman makan cokelat yang akan membuat ketagihan. Nikmati manisnya cokelat yang berpadu dengan buah kering yang lezat dan gurihnya kacang almond dalam setiap potong SilverQueen chocolate.",
        "Rinso Anti Noda merupakan pilihan detergen cair yang tepat untuk aktivitas mencuci di rumah Anda. Detergen ini mampu melindungi pakaian Anda dari bakteri secara maksimal sekaligus menghilangkan bau tak sedap pada pakaian.",
        "So Klin Softergent adalah kombinasi dari Deterjen dan Pelembut, mampu membersihkan noda sekaligus melembutkan kain dan pakaian dengan cara praktis dan ekonomis. Dengan 2x lebih banyak extra butiran pelembut, So Klin Softergent membuat pakaian menjadi 2x lebih lembut & 2x lebih wangi. Dilengkapi dengan formula Fresh Protection, Antibacterial Agent-nya membuat pakaian terlindungi dari bau apek meskipun dijemur di dalam ruangan dan dipakai beraktivitas seharian.",
        "DAIA Deterjen dengan 6 keunggulan mampu membersihkan pakaian secara all out dan menjaga warna tetap stand out. Dengan teknologi Dual Scent, White Booster, dan Softener terbagi di dalam 5 varian dari DAIA.",
        "Downy memperkenalkan inovasi terbaru, teknologi baru pada pelembut dan pewangi pakaian, yakni Scent Switcher. Pengembangan formula ini dapat mengubah keharuman pada pakaian setiap kali tergesek atau diusap",
        "Wafer Tango makanan favorit yang cocok dinikmati dimanapun berada dan untuk siapa saja, baik untuk anak-anak, orang tua dan lansia. Tekstur wafer yang renyah, kemasan yang menarik serta harganya yang sangat terjangkau, menjadikan produk Tango menjadi salah satu master wafer dalam persaingan produk lokal. Tango banyak berinovasi dengan menciptakan kreasi produk-produk baru, tapi tetap menjaga kualitas rasa.\n",
        "Chitato, yaitu makanan ringan dari kentang asli, renyah dan penuh rasa, diproses secara higienis dan modern tanpa bahan pengawet dan MSG.",
        "Koko Krunch sereal rasa coklat dari gandum utuh yang menyehatkan dan mudah dalam penyajiannya, cukup tambahkan susu menjadikan sarapan yang penuh nutrisi yang baik untuk kekuatan tubuh Kita sepanjang hari.",
        "Cheetos adalah sebuah merek keripik jagung renyah yang diproduksi oleh Frito-Lay, keripik ini terasa gurih dan asam-asin di dalamnya, kraker ini tersedia dengan berbagai rasa, tetapi yang paling populer adalah keju."
    )
    private val imageProduct = intArrayOf(
        R.drawable.teh_rio,
        R.drawable.teh_pucuk,
        R.drawable.teh_botol,
        R.drawable.beng_beng,
        R.drawable.dairy_milk,
        R.drawable.silver_queen,
        R.drawable.rinso,
        R.drawable.so_klin,
        R.drawable.daia,
        R.drawable.downy,
        R.drawable.tango,
        R.drawable.chitato,
        R.drawable.koko_krunch,
        R.drawable.cheetos
    )
    val data: ArrayList<ListStoreResponse>
        get() {
            val listProduct = arrayListOf<ListStoreResponse>()
            for(position in nameProduct.indices) {
                val result = ListStoreResponse()
                result.apply {
                    name = nameProduct[position]
                    expired = expiredProduct[position]
                    desc = descProduct[position]
                    image = imageProduct[position]
                }
                listProduct.add(result)
            }
            return listProduct
        }
    const val DATA_PRODUCT = "DATA_PRODUCT"
    const val NAME_PRODUCT = "NAME_PRODUCT"
    const val IMAGE_PRODUCT = "IMAGE_PRODUCT"
    const val EXPIRED_PRODUCT = "EXPIRED_PRODUCT"
    const val DESC_PRODUCT = "DESC_PRODUCT"
}