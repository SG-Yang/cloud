import {Injectable} from '@angular/core';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
/**
 * Created by aheroboy on 11/7/2017.
 */

@Injectable()
export class AxisService {
    drawAxis (canvasContext: any){
        canvasContext.strokeStyle = '#d5d5d5;border;0.1px solid #5fee23';
        canvasContext.lineWidth = 0.25;
        canvasContext.backgroundColor = '#5fee23'
        let x = canvasContext.canvas.width;
        let y = canvasContext.canvas.height;

        canvasContext.setLineDash([]);
        canvasContext.beginPath();
        canvasContext.moveTo(0 + 0.5, (y / 2) + 0.5);
        canvasContext.lineTo(x + 0.5 ,(y / 2) + 0.5);
        canvasContext.stroke();
        canvasContext.closePath();
        canvasContext.beginPath();
        canvasContext.moveTo(( x / 2 ) + 0.5, 0 + 0.5);
        canvasContext.lineTo((x / 2 ) + 0.5,y + 0.5);
        canvasContext.stroke();
        canvasContext.closePath();

        canvasContext.beginPath();
        canvasContext.moveTo(0, (y / 2) + 10.5);
        canvasContext.fillText(0,(x / 2) - 2 ,(y / 2) +4);
        let xAxis = x / 2;
        let xAxisLeft = xAxis;
        let xAxisRight = xAxis;
        let yAxis = y / 2;
        let drawAxisLeft = 0;
        let drawAxisRight = 0;
        while(xAxisLeft >= 0 && xAxisRight < x) {
            xAxisLeft = xAxisLeft - 40;
            xAxisRight = xAxisRight + 40;
            canvasContext.fillText(--drawAxisLeft,xAxisLeft+ 0.5  ,yAxis + 10.5);
            canvasContext.fillText(++drawAxisRight,xAxisRight + 0.5  ,yAxis + 10.5);
        }
        canvasContext.stroke();

        let sineV = 360;
        while ( sineV > 0 ) {
            sineV = sineV - 20;
            canvasContext.moveTo(sineV +5,180);
            canvasContext.lineTo(sineV,180);
        }
        sineV = 360;
        let sineVy = 0;
        while ( sineV > 0 ) {
            sineV = sineV - 20;
            sineVy = 180.0 - Math.sin(sineV *Math.PI/180)*120;
            canvasContext.lineTo(sineV,sineVy);
        }
        canvasContext.moveTo(0,180);
        canvasContext.stroke();
    }
}
