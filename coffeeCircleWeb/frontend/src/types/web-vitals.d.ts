declare module 'web-vitals' {
  export type ReportHandler = (metric: Metric) => void;

  export interface Metric {
    name: string;
    value: number;
    delta: number;
    id: string;
    entries: PerformanceEntry[];
  }

  export function onCLS(onReport: ReportHandler): void;
  export function onFID(onReport: ReportHandler): void;
  export function onFCP(onReport: ReportHandler): void;
  export function onLCP(onReport: ReportHandler): void;
  export function onTTFB(onReport: ReportHandler): void;
}
