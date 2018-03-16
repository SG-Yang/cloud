import {forEach} from "@angular/router/src/utils/collection";
/**
 * Created by aheroboy on 25/7/2017.
 */
export  class Params {
    params: any[];

    public toPathUrl(){
        let pathUrl;
        for(var p in this.params){

           if(pathUrl) {
               pathUrl = pathUrl + "/" + this.params[p];
           }else{
               pathUrl = this.params[p];
           }
           console.log(pathUrl);
        }

        return pathUrl;
    }
}
