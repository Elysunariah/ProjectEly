package com.ely.projectely.FragmentBottomNav

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.ely.projectely.BukuContract
import com.ely.projectely.R
import com.ely.projectely.database
import kotlinx.android.synthetic.main.fragment_create.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class CreateFragment : Fragment() {

    private var btn: Button? = null
    private var imageview: ImageView? = null
    private val GALLERY = 1
    private val CAMERA = 2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_create, container, false)
        btn = v.findViewById<View>(R.id.btnUpload) as Button
        imageview = v.findViewById<View>(R.id.imageUpload) as ImageView
        return v

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn!!.setOnClickListener {
            showPictureDialog()
        }
        btnSimpan.onClick {
            if (!validation()) {
                return@onClick
            }
            insertDatabase(activity!!.applicationContext)
        }

    }


    private fun insertDatabase(ctx : Context) {
        ctx.database.use {
            insert(
                BukuContract.TABLE_BUKU,
                BukuContract.JUDUL to et_judul.text.toString(),
                BukuContract.PHOTO to null,
                BukuContract.ISIBUKU to etMenulis.text.toString()
            )

            toast("Berhasil Menambahkan")
        }
    }

    private fun validation(): Boolean {
        when {
            et_judul.text.toString().isNotBlank() -> {
                et_judul.requestFocus()
                return true
            }
            etMenulis.text.toString().isNotBlank() -> {
                etMenulis.requestFocus()
                return true
            }
            else -> return false
        }

    }


    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(activity!!.applicationContext)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf("select Foto From Gallery", "Capture Foto From Camera")
        pictureDialog.setItems(pictureDialogItems) { dialog, which ->
            when (which) {
                0 -> chooseFotoFromGallery()
                1 -> takeFotoCamera()

            }
        }
        pictureDialog.show()
    }

    fun chooseFotoFromGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, GALLERY)
    }

    private fun takeFotoCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY) {
            if (data != null) {
                val contentURI = data!!.data
                try {
                    val bitmap =
                        MediaStore.Images.Media.getBitmap(activity!!.contentResolver, contentURI)
                    val path = saveImage(bitmap)
                    Toast.makeText(activity!!.applicationContext, "Image Saved", Toast.LENGTH_SHORT)
                        .show()
                    imageview!!.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(activity!!.application, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        } else if (requestCode == CAMERA) {
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            imageview!!.setImageBitmap(thumbnail)
            saveImage(thumbnail)
            Toast.makeText(activity!!.application, "Image Saved", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveImage(myBitmap: Bitmap): String {
        val bytes = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File(
            (Environment.getExternalStorageDirectory()).toString() + IMAGE_DIRECTORY
        )
        Log.d("fee", wallpaperDirectory.toString())
        if (wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs()
        }
        try {
            Log.d("heel", wallpaperDirectory.toString())
            val f = File(
                wallpaperDirectory, ((Calendar.getInstance()
                    .getTimeInMillis()).toString() + ".jpg")
            )
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            MediaScannerConnection.scanFile(
                activity,
                arrayOf(f.getPath()),
                arrayOf("image/jpg"), null
            )
            fo.close()
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath())

            return f.getAbsolutePath()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }
        return ""
    }

    companion object {
        private val IMAGE_DIRECTORY = "ely"
        fun newInstance(id: Int): CreateFragment {
            val fr = CreateFragment()
            val b = Bundle()
            fr.setArguments(b)
            return fr
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.optionsmenudua, menu)

//        menu!!.findItem(R.id.action_settings).isVisible = false
        menu!!.findItem(R.id.action_settings).isVisible = false

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.action_check) {
            Toast.makeText(activity, "Settings", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }




}