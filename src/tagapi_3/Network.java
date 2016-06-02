/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tagapi_3;

import java.io.File;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ammar
 */
public class Network {

    //this function needs to change in order to make it dynamic
    //all web urls come here...
    public final String https_libraries_minecraft_net = "https://libraries.minecraft.net";
    public final String http_resources_download_minecraft_net = "http://resources.download.minecraft.net"; 
    public final String https_s3_amazonaws_com_Minecraft_Download_versions = "https://s3.amazonaws.com/Minecraft.Download/versions";
    
    public void downloadLibraries(String OS ,String _url) {
        try {
            Utils utils = new Utils();
            URL url = new URL(_url);
            File file = new File(_url.replace(https_libraries_minecraft_net, utils.getMineCraftLibrariesLocation(OS)));
            if (file.exists()){
                //do not download..
                System.out.println("File Exists!");
            } else {
                FileUtils.copyURLToFile(url, file);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    //edit this
    public void downloadAssetsObjects(String OS, String folder, String _hash){
        //resources.download.minecraft.net/4b/4b90ff3a9b1486642bc0f15da0045d83a91df82e
        try {
            Utils utils = new Utils();
            URL url = new URL(http_resources_download_minecraft_net + "/" + folder + "/" + _hash);
            File file = new File(utils.getMineCraftAssetsObjectsLocation(OS) + "/" +  folder + "/" +  _hash);
            if (file.exists()){
                //do not download..
                System.out.println("File Exists!");
            } else {
                FileUtils.copyURLToFile(url, file);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public void downloadLaunchermeta(String OS, String _url, String version){
        try {
            Utils utils = new Utils();
            URL url = new URL(_url);
            File file = new File(utils.getMineCraftAssetsIndexes_X_json(OS, version));
            FileUtils.copyURLToFile(url, file);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    
    //modify this
    public void downloadMinecraftJar(String OS, String version){
        try {
            Utils utils = new Utils();
            URL url = new URL(https_s3_amazonaws_com_Minecraft_Download_versions + "/" + version + "/" + version + ".jar");
            File file = new File(utils.getMineCraft_Versions_X_X_jar(OS, version));
            if (file.exists()){
                //do not download..
                System.out.println("File Exists!");
            } else {
                FileUtils.copyURLToFile(url, file);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public void downloadVersionManifest( String _filepath){
        try {
            URL url = new URL("https://launchermeta.mojang.com/mc/game/version_manifest.json");
            File file = new File(_filepath);
            FileUtils.copyURLToFile(url, file);
        } catch (Exception e){
            System.out.print(e);
        }
    }

    public void downloadVersionJson(String OS, String _url, String versionnumber) {
         try {
            Utils utils = new Utils();
            URL url = new URL(_url);
            File file = new File(utils.getMineCraft_Versions_X_X_json(OS,versionnumber));
            if (file.exists()){
                //do not download..
                System.out.println("File Exists!");
            } else {
                FileUtils.copyURLToFile(url, file);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}