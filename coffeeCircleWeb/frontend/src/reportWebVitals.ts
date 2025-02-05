import { onCLS, onFID, onLCP, onTTFB, onFCP } from 'web-vitals';

export function reportWebVitals(onPerfEntry?: (metric: any) => void) {
	if (onPerfEntry && onPerfEntry === Function) {
		onCLS(onPerfEntry);
		onFCP(onPerfEntry);
		onFID(onPerfEntry);
		onLCP(onPerfEntry);
		onTTFB(onPerfEntry);
	}
}
export default reportWebVitals;